@FunctionalInterface
interface SquareCalculator {
    int square(int n);

    default void printSquare(int n) {
        int result = square(n);
        System.out.println("The square of " + n + " is: " + result);
    }
}

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        SquareCalculator calculator = n -> n * n;

        calculator.printSquare(4);
        calculator.printSquare(7);
    }
}

