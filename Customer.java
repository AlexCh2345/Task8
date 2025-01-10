import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(int productId) {
        cart.removeIf(product -> product.getId() == productId);
    }

    public void checkout() {
        double total = 0;
        System.out.println("Checkout for " + name + ":");
        for (Product product : cart) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Total cost: " + total);
    }
}
