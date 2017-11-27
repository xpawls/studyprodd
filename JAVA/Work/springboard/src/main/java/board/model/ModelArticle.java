package board.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelArticle {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer        articleno = null;        //`articleno` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    private String         boardcd   = "";        //`boardcd`   VARCHAR(20) NULL DEFAULT NULL,
    private String         title     = "";        //`title`     VARCHAR(200) NOT NULL,
    private String         content   = "";        //`content`   MEDIUMTEXT NULL,
    private String         email     = "";        //`email`     VARCHAR(60) NULL DEFAULT NULL,
    private Integer        hit       = null;        //`hit`       INT(10) UNSIGNED NULL DEFAULT '0',
    private java.util.Date regdate   = null;        //`regdate`   DATETIME NULL DEFAULT NULL,
    private Integer        countgood = null;        //`countgood` INT(11) NULL DEFAULT '0',
    private Integer        countbad  = null;        //`countbad`  INT(11) NULL DEFAULT '0',
    private Boolean        UseYN     = null;        //`UseYN`     TINYINT(1) NOT NULL DEFAULT '1',
    private String         InsertUID = "";        //`InsertUID` VARCHAR(40) NULL DEFAULT NULL,
    private java.util.Date InsertDT  = null;        //`InsertDT`  DATETIME NULL DEFAULT NULL,
    private String         UpdateUID = "";        //`UpdateUID` VARCHAR(40) NULL DEFAULT NULL,
    private java.util.Date UpdateDT  = null;        //`UpdateDT`  DATETIME NULL DEFAULT NULL,
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getHit() {
        return hit;
    }
    public void setHit(Integer hit) {
        this.hit = hit;
    }
    public java.util.Date getRegdate() {
        return regdate;
    }
    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }
    public Integer getCountgood() {
        return countgood;
    }
    public void setCountgood(Integer countgood) {
        this.countgood = countgood;
    }
    public Integer getCountbad() {
        return countbad;
    }
    public void setCountbad(Integer countbad) {
        this.countbad = countbad;
    }
    public Boolean getUseYN() {
        return UseYN;
    }
    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
    }
    public String getInsertUID() {
        return InsertUID;
    }
    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }
    public java.util.Date getInsertDT() {
        return InsertDT;
    }
    public void setInsertDT(java.util.Date insertDT) {
        InsertDT = insertDT;
    }
    public String getUpdateUID() {
        return UpdateUID;
    }
    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }
    public java.util.Date getUpdateDT() {
        return UpdateDT;
    }
    public void setUpdateDT(java.util.Date updateDT) {
        UpdateDT = updateDT;
    }
    
    @Override
    public String toString() {
        return "ModelArticle [articleno=" + articleno + ", boardcd=" + boardcd
                + ", title=" + title + ", content=" + content + ", email="
                + email + ", hit=" + hit + ", regdate=" + regdate
                + ", countgood=" + countgood + ", countbad=" + countbad
                + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                + ", UpdateDT=" + UpdateDT + "]";
    }
    public ModelArticle(Integer articleno, String boardcd, String title,
            String content, String email, Integer hit, Date regdate,
            Integer countgood, Integer countbad, Boolean useYN,
            String insertUID, Date insertDT, String updateUID, Date updateDT) {
        super();
        this.articleno = articleno;
        this.boardcd = boardcd;
        this.title = title;
        this.content = content;
        this.email = email;
        this.hit = hit;
        this.regdate = regdate;
        this.countgood = countgood;
        this.countbad = countbad;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }
    
    public ModelArticle() {
        super();
    }
    
    
    
}
