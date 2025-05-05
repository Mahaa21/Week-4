abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return getClass().getSimpleName() + ": " + name; }
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}

class Storage<T extends WarehouseItem> {
    private java.util.List<T> items = new java.util.ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public java.util.List<T> getItems() { return items; }
    public static void displayItems(java.util.List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("TV"));

        Storage<Groceries> groceries = new Storage<>();
        groceries.addItem(new Groceries("Bananas"));

        Storage<Furniture> furniture = new Storage<>();
        furniture.addItem(new Furniture("Sofa"));

        System.out.println("Electronics:");
        Storage.displayItems(electronics.getItems());

        System.out.println("Groceries:");
        Storage.displayItems(groceries.getItems());

        System.out.println("Furniture:");
        Storage.displayItems(furniture.getItems());
    }
}
