import java.math.BigDecimal;

public enum FuelType {
    PETROL("Petrol", new BigDecimal("4.50")),
    DIESEL("Diesel", new BigDecimal("4.80")),
    ELECTRIC("Electric", new BigDecimal("6.20"));

    private final String label;
    private final BigDecimal pricePerLiter;

    FuelType(String label, BigDecimal pricePerLiter) {
        this.label = label;
        this.pricePerLiter = pricePerLiter;
    }

    public String getLabel() {
        return label;
    }
}
