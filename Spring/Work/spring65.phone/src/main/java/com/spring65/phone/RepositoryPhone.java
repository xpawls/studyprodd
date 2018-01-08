package com.spring65.phone;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring65.phone.model.ModelPhone;

public class RepositoryPhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private List<ModelPhone> phoneItems;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public List<ModelPhone> getPhoneItems() {
        return phoneItems;
    }

    public void setPhoneItems(List<ModelPhone> phoneItems) {
        this.phoneItems = phoneItems;
    }

    @Override
    public String toString() {
        return "RepositoryPhone [logger=" + logger + ", phoneItems="
                + phoneItems + "]";
    }

    public RepositoryPhone(List<ModelPhone> phoneItems) {
        super();
        this.phoneItems = phoneItems;
    }

    public RepositoryPhone() {
        super();
    }
    
    
}
