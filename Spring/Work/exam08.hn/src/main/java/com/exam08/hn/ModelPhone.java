package com.exam08.hn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelPhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    

    private String  name         = "";   //name`          VARCHAR(50) NOT NULL,
    private String  manufacturer = "";   //manufacturer`  VARCHAR(30) NOT NULL,
    private Integer price        = null; //price`         INT(11) NOT NULL
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
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "ModelPhone [name=" + name + ", manufacturer=" + manufacturer
                + ", price=" + price + "]";
    }
    public ModelPhone(String name, String manufacturer, Integer price) {
        super();
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }
    public ModelPhone() {
        super();
    }
    
    
}
