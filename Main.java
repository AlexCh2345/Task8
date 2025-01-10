public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1, "Laptop", 1200.50);
        Product product2 = new Product(2, "Smartphone", 800.75);
        Product product3 = new Product(3, "Headphones", 150.30);


        Store store = new Store("TechStore");
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);


        store.listProducts();


        Customer customer = new Customer("John");


        customer.addToCart(product1);
        customer.addToCart(product2);


        customer.checkout();


        customer.removeFromCart(2);


        customer.checkout();


        store.removeProduct(3);


        store.listProducts();
    }
}





