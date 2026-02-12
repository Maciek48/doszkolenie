import java.util.Scanner;

public class Main {
    private static final String ALLOWED_OPERATORS = "+-*/%^";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        char decision;
        double lastResult;

        while (true) {
            try {
                double firstNum = readDouble(scanner, "Write first number: ");
                char operator = readOperator(scanner, "Write mathematical operator (available: +, -, *, /, %, ^): ");
                double secondNum = readDouble(scanner, "Write second number: ");

                double result = switch (operator) {
                    case '+' -> calculator.sum(firstNum, secondNum);
                    case '-' -> calculator.subtract(firstNum, secondNum);
                    case '*' -> calculator.multiply(firstNum, secondNum);
                    case '/' -> calculator.division(firstNum, secondNum);
                    case '%' -> calculator.modulo(firstNum, secondNum);
                    case '^' -> calculator.powerFirstNumber(firstNum, secondNum);
                    default -> throw new IllegalStateException("Unexpected operator: " + operator);
                };
                System.out.println("Result: " + result);
                lastResult = result;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            System.out.print("Press n to quit or y to enter new calculation: ");
            decision = scanner.next().charAt(0);
            if (decision == 'n') {
                System.out.println(lastResult > 0
                        ? "Last result is greater then zero"
                        : "Last result is smaller or equals zero");
                break;
            }
        }
        scanner.close();
    }

    private static double readDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static char readOperator(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.next();
            if (input.length() == 1 && ALLOWED_OPERATORS.contains(input)) {
                return input.charAt(0);
            }
            System.out.println("Invalid operator! Allowed: +, -, *, /, %, ^");
        }
    }
}