package Class_01_Book;

class Book {
    private String title;
    private int price;
    private String author;

    public Book() {
        this.title = null;
        this.price = 0;
        this.author = null;
    }

    public Book(String title) {
        this();              
        this.title = title;
    }

    public Book(String title, int price) {
        this(title);         
        this.price = price;
    }

    public Book(String title, int price, String author) {
        this(title, price);  
        this.author = author;
    }

    
    public String getTitle() { return this.title; }
    public int getPrice() { return this.price; }
    public String getAuthor() { return this.author; }

    
    public void setPrice(int price) { this.price = price; }
    public void setAuthor(String author) { this.author = author; }
    public void setTitle(String title) { this.title = title; }

    
    public String toString() {
        return "Book{title='" + title + "', price=" + price + ", author='" + author + "'}";
    }
}

public class Class_01_Book {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("제목");
        Book book3 = new Book("제목", 8000, "저자");

        book1.setAuthor("미정");
        book1.setPrice(0);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
    }
}
