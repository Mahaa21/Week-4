interface Category {}

class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void display() {
        System.out.println(name + " | $" + price + " | " + category.getClass().getSimpleName());
    }
}

public class OnlineMarketplace {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Guide", 100.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 25.0, new ClothingCategory());

        book.display();
        shirt.display();

        applyDiscount(book, 20);
        applyDiscount(shirt, 10);

        System.out.println("After Discounts:");
        book.display();
        shirt.display();
    }
}
