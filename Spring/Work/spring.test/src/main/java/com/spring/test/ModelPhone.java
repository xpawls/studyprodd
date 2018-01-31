package com.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelPhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String phname    = "";  //`phname`    VARCHAR(20) NOT NULL,
    private String phfactory = "";  //`phfactory` VARCHAR(40) NOT NULL,
    private Integer phprice  = null;  //`phprice`    INT(11) NOT NULL DEFAULT '0'
    public String getPhname() {
        return phname;
    }
    public void setPhname(String phname) {
        this.phname = phname;
    }
    public String getPhfactory() {
        return phfactory;
    }
    public void setPhfactory(String phfactory) {
        this.phfactory = phfactory;
    }
    public Integer getPhprice() {
        return phprice;
    }
    public void setPhprice(Integer phprice) {
        this.phprice = phprice;
    }
    @Override
    public String toString() {
        return "ModelPhone [logger=" + logger + ", phname=" + phname
                + ", phfactory=" + phfactory + ", phprice=" + phprice + "]";
    }
    public ModelPhone(String phname, String phfactory, Integer phprice) {
        super();
        this.phname = phname;
        this.phfactory = phfactory;
        this.phprice = phprice;
    }
    public ModelPhone() {
        super();
    }
    
    
    
}
