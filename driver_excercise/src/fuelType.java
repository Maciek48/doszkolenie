import java.math.BigDecimal;

public enum fuelType {
    PETROL("Petrol", new BigDecimal("4.50")),
    DIESEL("Diesel", new BigDecimal("4.80")),
    ELECTRIC("Electric", new BigDecimal("6.20"));

    private final String label;
    private final BigDecimal pricePerLiter;

    fuelType(String label, BigDecimal pricePerLiter) {
        this.label = label;
        this.pricePerLiter = pricePerLiter;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getPricePerLiter() {
        return pricePerLiter;
    }
}
