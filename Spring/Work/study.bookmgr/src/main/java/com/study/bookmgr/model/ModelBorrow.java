package com.study.bookmgr.model;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelBorrow {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer brno       = null;    // `brno`       INT(11) NOT NULL AUTO_INCREMENT,
    private String memname    = "";    //`memname`    VARCHAR(50) NULL DEFAULT NULL,
    private String memid    = "";    //`memname`    VARCHAR(50) NULL DEFAULT NULL,
    private String memphone   = "";    // `memphone`   VARCHAR(50) NULL DEFAULT NULL,
    private String memprinum  = "";    // `memprinum`  VARCHAR(50) NULL DEFAULT NULL,
    private String mememail   = "";    // `mememail`   VARCHAR(50) NULL DEFAULT NULL,
    private String bookname   = "";    // `bookname`   VARCHAR(50) NULL DEFAULT NULL,
    private String publisher  = "";    // `publisher`  VARCHAR(50) NULL DEFAULT NULL,
    private String category   = "";    // `category`   VARCHAR(50) NULL DEFAULT NULL,
    private String author     = "";    //`author`     VARCHAR(50) NULL DEFAULT NULL,
    private Integer bookno     = null;    //`bookno`     INT(11) NULL DEFAULT NULL,
    private java.sql.Date borrowdate = null;    //  `borrowdate` DATE NULL DEFAULT NULL,
    
    
    public String getMemid() {
        return memid;
    }
    public void setMemid(String memid) {
        this.memid = memid;
    }
    public Integer getBrno() {
        return brno;
    }
    public void setBrno(Integer brno) {
        this.brno = brno;
    }
    public String getMemname() {
        return memname;
    }
    public void setMemname(String memname) {
        this.memname = memname;
    }
    public String getMemphone() {
        return memphone;
    }
    public void setMemphone(String memphone) {
        this.memphone = memphone;
    }
    public String getMemprinum() {
        return memprinum;
    }
    public void setMemprinum(String memprinum) {
        this.memprinum = memprinum;
    }
    public String getMememail() {
        return mememail;
    }
    public void setMememail(String mememail) {
        this.mememail = mememail;
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
    public Integer getBookno() {
        return bookno;
    }
    public void setBookno(Integer bookno) {
        this.bookno = bookno;
    }
    public java.sql.Date getBorrowdate() {
        return borrowdate;
    }
    public void setBorrowdate(java.sql.Date borrowdate) {
        this.borrowdate = borrowdate;
    }
    
    @Override
    public String toString() {
        return "ModelBorrow [logger=" + logger + ", brno=" + brno + ", memname="
                + memname + ", memid=" + memid + ", memphone=" + memphone
                + ", memprinum=" + memprinum + ", mememail=" + mememail
                + ", bookname=" + bookname + ", publisher=" + publisher
                + ", category=" + category + ", author=" + author + ", bookno="
                + bookno + ", borrowdate=" + borrowdate + "]";
    }
    
    
    public ModelBorrow(Integer brno, String memname, String memid,
            String memphone, String memprinum, String mememail, String bookname,
            String publisher, String category, String author, Integer bookno,
            Date borrowdate) {
        super();
        this.brno = brno;
        this.memname = memname;
        this.memid = memid;
        this.memphone = memphone;
        this.memprinum = memprinum;
        this.mememail = mememail;
        this.bookname = bookname;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
        this.bookno = bookno;
        this.borrowdate = borrowdate;
    }
    public ModelBorrow() {
        super();
    }
    
    
    
}
