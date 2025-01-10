public class Main {
    public static void main(String[] args) {

        Product milk = new Product("milk", 5);
        Product cereal = new Product("cereal", 10);
        Product cookes = new Product("cookes",15);

        Book book1 = new Book("Майстер і Маргарита", "Михайло Булгаков", 448);
        Book book2 = new Book("Вій", "Николай Гоголь", 144);
        Book book3 = new Book("1984", "Джордж Орвелл", 328);


        Library library = new Library();
        Shop shop = new Shop();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);


        library.showBooks();

        shop.addProduct(milk);
        shop.addProduct(cereal);
        shop.addProduct(cookes);

        shop.showProducts();
    }
}


