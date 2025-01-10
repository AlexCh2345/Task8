import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private List<Product> products;

    public Store(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    public void listProducts() {
        System.out.println("Products in store '" + name + "':");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
