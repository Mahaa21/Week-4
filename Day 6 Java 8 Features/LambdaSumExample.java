@FunctionalInterface
interface SumFunction {
    int sum(int a, int b);
}

public class LambdaSumExample {
    public static void main(String[] args) {
        SumFunction add = (a, b) -> a + b;
        int result1 = add.sum(5, 10);
        int result2 = add.sum(20, 30);

        System.out.println("Sum of 5 and 10 is: " + result1);
        System.out.println("Sum of 20 and 30 is: " + result2);
    }
}
