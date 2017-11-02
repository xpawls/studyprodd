package java31.st3bookmanagement;

public class BookD {
    private Integer no        = null;
    private String  bookname  = "";
    private String  publisher = "";
    private String  category  = "";
    private String  author    = "";
    private Integer price     = null;
    private Boolean borrow_yn = true;
    
    public BookD(Integer no, String bookname, String publisher,
            String category, String author, Integer price, Boolean borrow_yn) {
        super();
        this.no = no;
        this.bookname = bookname;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
        this.price = price;
        this.borrow_yn = borrow_yn;
    }
    public BookD(Integer no, String bookname, String publisher,
            String category, String author, Integer price) {
        super();
        this.no = no;
        this.bookname = bookname;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
        this.price = price;
    }
    public BookD() {
        super();
    }
    public Integer getNo() {
        return no;
    }
    public void setNo(Integer no) {
        this.no = no;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Boolean getBorrow_yn() {
        return borrow_yn;
    }
    public void setBorrow_yn(Boolean borrow_yn) {
        this.borrow_yn = borrow_yn;
    }
    
    
    
    
    
    
    
}
