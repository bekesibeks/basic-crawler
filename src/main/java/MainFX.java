import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Map;

public class MainFX extends Application {

    private TableView<RateData> table = new TableView<RateData>();
    private final ObservableList<RateData> data =
            FXCollections.observableArrayList(
                    new RateData("Otp", 100, 10001d, 0d, 0d)
            );


    private final RateUpdateScheduler updater;

    public MainFX() {
        this.updater = new RateUpdateScheduler();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group(), 400, 300);
        StackPane root = new StackPane();
        primaryStage.setTitle("My broker");

        Button btn = createButton();
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(
                new PropertyValueFactory<RateData, String>("name"));

        TableColumn quantity = new TableColumn("Quantity");
        quantity.setCellValueFactory(
                new PropertyValueFactory<RateData, Integer>("quantity"));

        TableColumn baseRate = new TableColumn("Base");
        baseRate.setCellValueFactory(
                new PropertyValueFactory<RateData, Double>("baseRate"));

        TableColumn currentRate = new TableColumn("Current");
        currentRate.setCellValueFactory(
                new PropertyValueFactory<RateData, Double>("currentRate"));

        TableColumn delta = new TableColumn("Delta");
        delta.setCellValueFactory(
                new PropertyValueFactory<RateData, Double>("delta"));

        table.setItems(data);
        table.getColumns().addAll(name, quantity, baseRate, currentRate, delta);
        table.setMaxHeight(200);

        VBox vbox = new VBox();
        vbox.setSpacing(2);
        vbox.setPadding(new Insets(5, 0, 0, 5));
        vbox.getChildren().addAll(table, btn);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton() {
        Button btn = new Button();
        btn.setText("Update");
        btn.setOnMouseClicked((event) -> {
            Map<RateType, Double> currentRates = updater.getCurrentRates();
            data.get(0).setDelta(34d);
            table.refresh();
            System.out.println(currentRates);
        });
        return btn;
    }
}