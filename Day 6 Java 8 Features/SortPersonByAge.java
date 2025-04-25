import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Salary: $" + salary + ")";
    }
}

public class SortPersonByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, 60000),
                new Person("Bob", 25, 55000),
                new Person("Charlie", 35, 70000),
                new Person("Diana", 28, 58000)
        );
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        System.out.println("Sorted by age (ascending):");
        people.forEach(System.out::println);
    }
}
