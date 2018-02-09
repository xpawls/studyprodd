package com.study.bookmgr.model;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    private Integer       bno     = null;// `bno    `    INT(11) NOT NULL,
    private String        boardcd = "";// `title ` VARCHAR(50) NULL DEFAULT NULL,
    private String        title   = "";// `title ` VARCHAR(50) NULL DEFAULT NULL,
    private String        content = "";
    private String        memid   = "";// `id     `     VARCHAR(50) NULL DEFAULT NULL,
    private Integer       hit     = null;
    private java.sql.Date updatedt = null;// `date   `    DATE NULL DEFAULT NULL,
    private Integer       useyn   = null;
    private Integer       commentNum = null;
    
    
    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getHit() {
        return hit;
    }
    public void setHit(Integer hit) {
        this.hit = hit;
    }
    public java.sql.Date getUpdatedt() {
        return updatedt;
    }
    public void setUpdatedt(java.sql.Date updatedt) {
        this.updatedt = updatedt;
    }
    public Integer getUseyn() {
        return useyn;
    }
    public void setUseyn(Integer useyn) {
        this.useyn = useyn;
    }
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public Integer getBno() {
        return bno;
    }
    public void setBno(Integer bno) {
        this.bno = bno;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    public String getMemid() {
        return memid;
    }
    public void setMemid(String memid) {
        this.memid = memid;
    }
    
    
    public Integer getCommentNum() {
        return commentNum;
    }
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
    @Override
    public String toString() {
        return "ModelBoard [logger=" + logger + ", bno=" + bno + ", title="
                + title + ", content=" + content + ", memid=" + memid + ", hit=" + hit
                + ", updatedt=" + updatedt + ", useyn=" + useyn + "]";
    }
    
    
    
    public ModelBoard(Integer bno, String title, String content,
            String memid, Integer hit, Date updatedt, Integer useyn,
            Integer commentNum) {
        super();
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.memid = memid;
        this.hit = hit;
        this.updatedt = updatedt;
        this.useyn = useyn;
        this.commentNum = commentNum;
    }
    
    public ModelBoard(Integer bno, String boardcd, String title, String content,
            String memid, Integer hit, Date updatedt, Integer useyn,
            Integer commentNum) {
        super();
        this.bno = bno;
        this.boardcd = boardcd;
        this.title = title;
        this.content = content;
        this.memid = memid;
        this.hit = hit;
        this.updatedt = updatedt;
        this.useyn = useyn;
        this.commentNum = commentNum;
    }
    public ModelBoard() {
        super();
    }
    
    
    
}
