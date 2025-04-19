import java.util.*;

public class ShoppingCart {

    private Map<String, Double> productPrices;
    private Map<String, Double> cartItems;
    private Map<String, Double> sortedItems;

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cartItems = new LinkedHashMap<>();
        this.sortedItems = new TreeMap<>();
    }

    public void addProductToCatalog(String product, double price) {
        productPrices.put(product, price);
    }

    public void addItemToCart(String product) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, productPrices.get(product));
            sortedItems.put(product, productPrices.get(product));
        } else {
            System.out.println("Product not found in catalog.");
        }
    }

    public void displayCartItemsInOrder() {
        System.out.println("Cart Items (in order of addition):");
        for (Map.Entry<String, Double> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void displaySortedCartItems() {
        System.out.println("\nCart Items Sorted by Price:");
        for (Map.Entry<String, Double> entry : sortedItems.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void displayTotalCost() {
        double total = 0;
        for (double price : cartItems.values()) {
            total += price;
        }
        System.out.println("\nTotal Cost: $" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProductToCatalog("Laptop", 1200.00);
        cart.addProductToCatalog("Headphones", 150.00);
        cart.addProductToCatalog("Smartphone", 800.00);
        cart.addProductToCatalog("Tablet", 400.00);

        cart.addItemToCart("Laptop");
        cart.addItemToCart("Headphones");
        cart.addItemToCart("Smartphone");

        cart.displayCartItemsInOrder();
        cart.displaySortedCartItems();
        cart.displayTotalCost();
    }
}
