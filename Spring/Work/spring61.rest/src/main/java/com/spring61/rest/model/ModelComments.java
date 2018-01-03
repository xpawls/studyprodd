package com.spring61.rest.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelComments {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private Integer        commentno = null;     //`commentno`    INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    private Integer        articleno = null;     //`articleno`    INT(10) UNSIGNED NOT NULL,
    private String         email     = "";    //`email`       VARCHAR(60) NULL DEFAULT NULL,
    private String         memo      = "";    //`memo`         VARCHAR(4000) NULL DEFAULT NULL,
    private java.util.Date regdate   = null;    //`regdate`     DATETIME NULL DEFAULT NULL,
    private Boolean        UseYN     = null;    //`UseYN`        TINYINT(1) NULL DEFAULT '1',
    private String         InsertUID = "";     //`InsertUID`    VARCHAR(40) NULL DEFAULT NULL,
    private java.util.Date InsertDT  = null;    //`InsertDT`    DATETIME NULL DEFAULT NULL,
    private String         UpdateUID = "";     //`UpdateUID`    VARCHAR(40) NULL DEFAULT NULL,
    private java.util.Date UpdateDT  = null;    //`UpdateDT`    DATETIME NULL DEFAULT NULL,
    public Integer getCommentno() {
        return commentno;
    }
    public void setCommentno(Integer commentno) {
        this.commentno = commentno;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public java.util.Date getRegdate() {
        return regdate;
    }
    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
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
        return "ModelComments [commentno=" + commentno + ", articleno="
                + articleno + ", email=" + email + ", memo=" + memo
                + ", regdate=" + regdate + ", UseYN=" + UseYN + ", InsertUID="
                + InsertUID + ", InsertDT=" + InsertDT + ", UpdateUID="
                + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
    public ModelComments(Integer commentno, Integer articleno, String email,
            String memo, Date regdate, Boolean useYN, String insertUID,
            Date insertDT, String updateUID, Date updateDT) {
        super();
        this.commentno = commentno;
        this.articleno = articleno;
        this.email = email;
        this.memo = memo;
        this.regdate = regdate;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }
    public ModelComments() {
        super();
    }
    
    
}
