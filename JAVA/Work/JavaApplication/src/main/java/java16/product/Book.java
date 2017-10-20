package java16.product;

public class Book extends Product {
    private int isbn = 0;
    protected String author = ""; //저자
    protected String bookname = "";
    // get set
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    // constructor
    public Book(int id, String pe, String pr, int price, int isbn,
            String author, String bookname) {
        super(id, pe, pr, price);
        this.isbn = isbn;
        this.author = author;
        this.bookname = bookname;
    }
    public Book() {
        super();
    }
    
    
}
