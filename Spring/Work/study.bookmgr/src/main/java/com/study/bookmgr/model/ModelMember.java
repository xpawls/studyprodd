package com.study.bookmgr.model;

public class ModelMember {
    private Integer memNo     = null;
    private String  memName   = "";
    private String  memPriNum = "";
    private String  memPhone  = "";
    private String  memEmail  = "";
    private String  memID     = "";
    private String  memPW     = "";
    private Integer level     = null;
    
    
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getMemID() {
        return memID;
    }
    public void setMemID(String memID) {
        this.memID = memID;
    }
    public String getMemPW() {
        return memPW;
    }
    public void setMemPW(String memPW) {
        this.memPW = memPW;
    }
    public Integer getMemNo() {
        return memNo;
    }
    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }
    public String getMemName() {
        return memName;
    }
    public void setMemName(String memName) {
        this.memName = memName;
    }
    public String getMemPriNum() {
        return memPriNum;
    }
    public void setMemPriNum(String memPriNum) {
        this.memPriNum = memPriNum;
    }
    public String getMemPhone() {
        return memPhone;
    }
    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }
    public String getMemEmail() {
        return memEmail;
    }
    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }
    
    public ModelMember(String memID, String memPW) {
        super();
        this.memID = memID;
        this.memPW = memPW;
    }
    public ModelMember(Integer memNo, String memName, String memPriNum,
            String memPhone, String memEmail, String memID, String memPW) {
        super();
        this.memNo = memNo;
        this.memName = memName;
        this.memPriNum = memPriNum;
        this.memPhone = memPhone;
        this.memEmail = memEmail;
        this.memID = memID;
        this.memPW = memPW;
    }
    public ModelMember(Integer memNo, String memName, String memPriNum,
            String memPhone, String memEmail) {
        super();
        this.memNo = memNo;
        this.memName = memName;
        this.memPriNum = memPriNum;
        this.memPhone = memPhone;
        this.memEmail = memEmail;
    }
    
    
    public ModelMember() {
        super();
    }
    @Override
    public String toString() {
        return "ModelMember [memNo=" + memNo + ", memName=" + memName
                + ", memPriNum=" + memPriNum + ", memPhone=" + memPhone
                + ", memEmail=" + memEmail + ", memID=" + memID + ", memPW="
                + memPW + ", level=" + level + "]";
    }
    
    
    
}
