import java.util.*;
import java.util.stream.*;

class Sale {
    int productId;
    int quantity;
    double price;

    public Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class ProductSales {
    int productId;
    double totalRevenue;

    public ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public int getProductId() {
        return productId;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductSales{productId=" + productId + ", totalRevenue=" + totalRevenue + "}";
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale(101, 15, 20.0),
                new Sale(102, 5, 50.0),
                new Sale(103, 12, 30.0),
                new Sale(104, 20, 10.0),
                new Sale(105, 8, 40.0),
                new Sale(106, 25, 15.0),
                new Sale(107, 18, 25.0)
        );

        List<Sale> filteredSales = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .collect(Collectors.toList());

        List<ProductSales> productSalesList = filteredSales.stream()
                .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
                .collect(Collectors.toList());

        List<ProductSales> sortedProductSales = productSalesList.stream()
                .sorted((p1, p2) -> Double.compare(p2.getTotalRevenue(), p1.getTotalRevenue()))
                .collect(Collectors.toList());

        List<ProductSales> top5Products = sortedProductSales.stream()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 Products by Total Revenue:");
        top5Products.forEach(System.out::println);
    }
}
