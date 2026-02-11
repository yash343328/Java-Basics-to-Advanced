import java.util.ArrayList;

// Abstract Product class
abstract class Product {
    protected String name;
    protected double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double getPrice();
}

// Concrete product classes
class Electronics extends Product {
    private double warrantyCharge;

    Electronics(String name, double price, double warrantyCharge) {
        super(name, price);
        this.warrantyCharge = warrantyCharge;
    }

    @Override
    double getPrice() {
        return price + warrantyCharge;
    }
}

class Grocery extends Product {
    private double discount;

    Grocery(String name, double price, double discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    double getPrice() {
        return price - discount;
    }
}

// Shopping Cart
class Cart {
    private ArrayList<Product> products;

    Cart() {
        products = new ArrayList<>();
    }

    void addProduct(Product p) {
        products.add(p);
        System.out.println(p.name + " added to cart.");
    }

    void calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        System.out.println("Total Cart Value: " + total);
    }
}

// Main Class
public class OnlineShoppingCart {
    public static void main(String[] args) {

        Cart cart = new Cart();

        Product p1 = new Electronics("Smartphone", 20000, 2000);
        Product p2 = new Grocery("Rice", 2000, 100);

        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.calculateTotal();
    }
}
