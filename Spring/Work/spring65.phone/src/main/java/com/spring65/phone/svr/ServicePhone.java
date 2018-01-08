package com.spring65.phone.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring65.phone.inf.IDaoPhone;
import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

@Service("servicephone")
public class ServicePhone implements IServicePhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daophone")
    private IDaoPhone dao;

    @Override
    public ModelPhone getPhoneOne(String name){
        ModelPhone rs = null;
        try {
            rs = dao.getPhoneOne(name);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getPhoneOne" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> rs = null;
        try {
            rs = dao.getPhoneList();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getPhoneList" + e.getMessage());
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

    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        int rs = -1;
        try {
            rs = dao.insertPhoneList(phones);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertPhoneList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
