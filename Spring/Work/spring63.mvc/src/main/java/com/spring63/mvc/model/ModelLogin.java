package com.spring63.mvc.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelLogin {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name;
    private String pw;
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getpw() {
        return pw;
    }
    public void setpw(String pw) {
        this.pw = pw;
    }
    @Override
    public String toString() {
        return "ModelLogin [logger=" + logger + ", name=" + name + ", pw="
                + pw + "]";
    }
    public ModelLogin(String name, String pw) {
        super();
        this.name = name;
        this.pw = pw;
    }
    public ModelLogin() {
        super();
    }
    
    
}
