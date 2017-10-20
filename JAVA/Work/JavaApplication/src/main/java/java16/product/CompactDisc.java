package java16.product;

public class CompactDisc extends Product {
    protected String albumname = "";
    protected String singername = "";
    // get set
    public String getAlbumname() {
        return albumname;
    }
    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }
    public String getSingername() {
        return singername;
    }
    public void setSingername(String singername) {
        this.singername = singername;
    }
    // constructor
    public CompactDisc(int id, String pe, String pr, int price,
            String albumname, String singername) {
        super(id, pe, pr, price);
        this.albumname = albumname;
        this.singername = singername;
    }
    public CompactDisc() {
        super();
    }
    
    
}
