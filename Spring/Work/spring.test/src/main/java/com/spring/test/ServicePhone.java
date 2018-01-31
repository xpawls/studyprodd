package com.spring.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePhone implements IServicePhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoPhone dao;

    @Override
    public List<ModelPhone> selectAll() {
        List<ModelPhone> rs = null;
        
        try {
            rs = dao.selectAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectAll" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        int rs = -1;
        
        try {
            rs = dao.insertPhone(phone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertPhone" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
