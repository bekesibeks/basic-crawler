public enum RateType {

    OTP("ul > li:nth-child(4) > a > span.price"),
    MOL("ul > li:nth-child(5) > a > span.price"),
    TELEKOM("ul > li:nth-child(7) > a > span.price"),
    FOURIG("ul > li:nth-child(9) > a > span.price");

    private final String selector;

    RateType(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
