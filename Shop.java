import java.util.ArrayList;
import java.util.List;
class Shop {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }


    public void showProducts() {
        System.out.println("Список товарів у магазині:");
        for (Product product : products) {
            System.out.println("Назва: " + product.name + ", Ціна: " + product.price);
        }
    }
}

