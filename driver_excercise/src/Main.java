import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Motorcycle moto = new Motorcycle(
                "Yamaha",
                "R6",
                LocalDate.of(2018, 1, 1),
                FuelType.PETROL,
                20,
                15.0
        );

        Car car = new Car(
                "BMW",
                "E46",
                LocalDate.of(2005, 1, 1),
                FuelType.DIESEL,
                60,
                40.0,
                4
        );

        System.out.println("=== TEST MOTORCYCLE ===");
        moto.displayInfo();
        moto.drive();
        moto.refuel(3);
        moto.refuel(50);
        moto.displayInfo();

        System.out.println("\n=== TEST CAR ===");
        car.displayInfo();
        car.drive();
        car.refuel(5);
        car.refuel(100);
        car.displayInfo();

        System.out.println("\n=== TEST POLIMPRPHISM ===");
        List<Vehicle> list = new ArrayList<>(List.of(moto, car));
        for (Vehicle v : list) {
            v.displayInfo();
        }
    }
}