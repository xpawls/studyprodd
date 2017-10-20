package java16.product;

public class ConversationBook extends Book {
    protected String lang = ""; // 언어명

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ConversationBook(int id, String pe, String pr, int price, int isbn,
            String author, String bookname, String lang) {
        super(id, pe, pr, price, isbn, author, bookname);
        this.lang = lang;
    }

    public ConversationBook(String lang) {
        super();
        this.lang = lang;
    }

    public ConversationBook() {
        super();
    }
    
    
}
