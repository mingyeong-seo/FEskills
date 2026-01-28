package Class_01_Book;

class Book {
	private String title;
	private int price;
	private String author;

	public Book() {
		title = null;
		price = 0;
		author = null;
	}

	public Book(String title) {
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
	
	public String getTitle() {
		return this.title = title;
	}
	public int getPrice() {
		return this.price = price;
	}
	public String getAuthor() {
		return this.author = author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}

public class Class_01_Book {
	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("제목");
		Book book3 = new Book("제목", 8000, "저자");
		
		book1.setAuthor(null);
		book1.setPrice(0);
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
	}

}
