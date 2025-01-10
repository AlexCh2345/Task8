import java.util.ArrayList;

class Library {
            private ArrayList<Book> books;


            public Library() {
                books = new ArrayList<>();
            }


            public void addBook(Book book) {
                books.add(book);
            }


            public void showBooks() {
                if (books.isEmpty()) {
                    System.out.println("Бібліотека порожня.");
                } else {
                    System.out.println("Книги в бібліотеці:");
                    for (Book book : books) {
                        System.out.println(book);
                    }
                }
            }
        }


