import java.time.LocalDate;

public class Motorcycle extends Vehicle implements Driveable {

    public Motorcycle(String brand, String model, LocalDate year, FuelType fuelType, int tankCapacity, double fuelLevel) {
        super(brand, model, year, fuelType, tankCapacity, fuelLevel);
    }

    @Override
    public void drive() {
        int consumption = 5;
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
        System.out.printf("You drove 10km. Fuel left: %.2f%n", getFuelLevel());
    }

    @Override
    public void displayInfo() {
        System.out.printf("""
                        Info about the Motorcycle:
                        Brand: %s
                        Model: %s
                        Year: %s
                        Fuel type: %s
                        Tank capacity: %d
                        Fuel level: %.2f
                        """,
                getBrand(),
                getModel(),
                getYear(),
                getFuelType().getLabel(),
                getTankCapacity(),
                getFuelLevel()
        );
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Liters must be > 0.");
            return;
        }
        if (getFuelLevel() + liters > getTankCapacity()) {
            double maxLiters = getTankCapacity() - getFuelLevel();
            System.out.printf("Too much fuel. You can refuel at most: %.2f liters%n", maxLiters);
            return;
        }
        setFuelLevel(getFuelLevel() + liters);
        System.out.printf("Refueled. Fuel level is now: %.2f%n", getFuelLevel());
    }
}