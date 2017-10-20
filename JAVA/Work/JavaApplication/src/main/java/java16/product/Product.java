package java16.product;

public class Product {
    private int id = 0; // 고유식별자
    private String pe = ""; // 상품설명
    private String pr = ""; // 생산자
    private int price = 0;
    
    // get set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPe() {
        return pe;
    }
    public void setPe(String pe) {
        this.pe = pe;
    }
    public String getPr() {
        return pr;
    }
    public void setPr(String pr) {
        this.pr = pr;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    // constructor
    public Product(int id, String pe, String pr, int price) {
        super();
        this.id = id;
        this.pe = pe;
        this.pr = pr;
        this.price = price;
    }
    public Product() {
        super();
    }
    
    
}
