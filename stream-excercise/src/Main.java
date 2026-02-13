import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Zadanie 8
        System.out.println("============== Zadanie 8 ==============");
        List<Employee> employees = List.of(
                new Employee("Maciek", 30, "IT"),
                new Employee("Kasia", 22, "HR"),
                new Employee("Bartek", 28, "IT"),
                new Employee("Ania", 26, "Finanse"),
                new Employee("Zosia", 24, "HR"),
                new Employee("Tomek", 40, "Finanse")
        );

        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getAge() > 25)
                .toList();

        System.out.println("Pracownicy powyżej 25 lat:");
        filteredEmployees.forEach(System.out::println);

        List<String> namesSorted = employees.stream()
                .filter(e -> e.getAge() > 25)
                .map(Employee::getName)
                .sorted()
                .toList();

        System.out.println("\nImiona pracowników > 25 lat (posortowane):");
        namesSorted.forEach(System.out::println);

        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nPracownicy pogrupowani według działu:");
        groupedByDepartment.forEach((department, list) -> {
            System.out.println(department + ": " + list);
        });

        //Zadanie 9
        System.out.println("\n============== Zadanie 9 ==============");
        List<String> sentences = Arrays.asList(
                "hello world",
                "java streams",
                "world of code"
        );

        String result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(result);
    }
}