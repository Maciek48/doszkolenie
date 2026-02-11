import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        char decision = 'y';
        double lastResult = 0;

        while (decision != 'n') {
            System.out.print("Write first number: ");
            double firstNum = scanner.nextDouble();

            System.out.print("Write mathematical operator (available: +, -, *, /, %, ^): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Write second number: ");
            double secondNum = scanner.nextDouble();

            double result = switch (operator) {
                case '+' -> calculator.sum(firstNum, secondNum);
                case '-' -> calculator.substract(firstNum, secondNum);
                case '*' -> calculator.multiply(firstNum, secondNum);
                case '/' -> calculator.division(firstNum, secondNum);
                case '%' -> calculator.modulo(firstNum, secondNum);
                case '^' -> calculator.powerFirstNumber(firstNum, secondNum);
                default -> throw new IllegalArgumentException("Unknown operator: " + operator);
            };

            System.out.println("Result: " + result);
            lastResult = result;

            while (decision != 'n' && decision != 'y') {
                System.out.print("Press n to quit or y to enter new calculation: ");
                decision = scanner.next().charAt(0);
            }
        }
        System.out.println(lastResult > 0
                ? "Last result grater then zero"
                : "Last result is smaller or equals zero");

        scanner.close();
    }
}