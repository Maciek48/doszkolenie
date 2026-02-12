import java.time.LocalDate;

public abstract class Vehicle {
    private String brand, model;
    private LocalDate year;
    private fuelType fuelType;
    private int tankCapacity;
    private double fuelLevel;

    public Vehicle(String brand, String model, LocalDate year, fuelType fuelType, int tankCapacity, double fuelLevel){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
        this.fuelLevel = Math.min(fuelLevel, tankCapacity);
    }

    public abstract void displayInfo();
    public abstract void refuel(double liters);

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getYear() {
        return year;
    }

    public fuelType getFuelType() {
        return fuelType;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}