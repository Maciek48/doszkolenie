import static java.lang.Math.pow;

public class Calculator {
    public double sum(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }
        return a / b;
    }

    public double modulo(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division modulo by 0 is not allowed");
        }
        return a % b;
    }

    public double powerFirstNumber(double a, double b) {
        return pow(a, b);
    }
}