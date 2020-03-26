public class RateData {

    private String name;
    private Integer quantity;

    private Double baseRate;
    private Double currentRate;

    private Double delta;

    public RateData(String name, Integer quantity, Double baseRate, Double currentRate, Double delta) {
        this.name = name;
        this.quantity = quantity;
        this.baseRate = baseRate;
        this.currentRate = currentRate;
        this.delta = delta;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getBaseRate() {
        return baseRate;
    }

    public Double getCurrentRate() {
        return currentRate;
    }

    public Double getDelta() {
        return delta;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }

    public void setCurrentRate(Double currentRate) {
        this.currentRate = currentRate;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }
}
