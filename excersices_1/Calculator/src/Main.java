import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        char decision;
        double lastResult;

        while (true) {
            try {
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
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.out.println("Wrong input. Try again.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Press n to quit or y to enter new calculation: ");
            decision = scanner.next().charAt(0);
            if (decision == 'n') {
                System.out.println(lastResult > 0
                        ? "Last result is grater then zero"
                        : "Last result is smaller or equals zero");
                break;
            }
        }
        scanner.close();
    }
}