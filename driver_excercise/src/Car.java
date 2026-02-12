import java.time.LocalDate;

public class Car extends Vehicle implements Driveable {

    private int doors;

    public Car(String brand, String model, LocalDate year, fuelType fuelType, int tankCapacity, double fuelLevel, int doors) {
        super(brand, model, year, fuelType, tankCapacity, fuelLevel);
        if (doors <= 0) {
            throw new IllegalArgumentException("Car must have at least 1 door");
        }
        this.doors = doors;
    }

    @Override
    public void drive() {
        double consumption = 8.0;
        if (getFuelLevel() <= 0) {
            System.out.println("No fuel! You can't drive.");
            return;
        }
        if (getFuelLevel() < consumption) {
            setFuelLevel(0);
            System.out.println("Fuel ran out during the drive. Fuel level is now 0.");
            return;
        }
        setFuelLevel(getFuelLevel() - consumption);
        System.out.printf("You drove the car. Fuel left: %.2f L%n", getFuelLevel());
    }

    @Override
    public void displayInfo() {
        System.out.printf("""
                        Info about the Car:
                        Brand: %s
                        Model: %s
                        Year: %s
                        Fuel type: %s
                        Doors: %d
                        Tank capacity: %d
                        Fuel level: %.2f
                        """,
                getBrand(),
                getModel(),
                getYear(),
                getFuelType().getLabel(),
                doors,
                getTankCapacity(),
                getFuelLevel()
        );
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Liters must be greater than 0.");
            return;
        }
        if (getFuelLevel() + liters > getTankCapacity()) {
            double maxLiters = getTankCapacity() - getFuelLevel();
            System.out.printf("Too much fuel. You can refuel at most: %.2f liters%n", maxLiters);
            return;
        }
        setFuelLevel(getFuelLevel() + liters);
        System.out.printf("Refueled car. Fuel level is now: %.2f L%n", getFuelLevel());
    }
}