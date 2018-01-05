package com.spring61.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring61.rest.inf.IServiceUser;
import com.spring61.rest.inf.IUser;
import com.spring61.rest.model.ModelUser;

@Service("serviceuser")
public class ServiceUser implements IServiceUser {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daouser")
    private IUser dao;
    
    @Override
    public int insertUser(ModelUser user) {
        int rs = -1;
        try {
            rs = dao.insertUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertUser" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelUser login(String userid, String passwd) {
        ModelUser lis = null;
        try {
            lis = dao.login(userid, passwd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("login" + e.getMessage());
            throw e;
            
        }
        return lis;
    }
    
    @Override
    public int logout(String log) {
        int rs = -1;
        try {
            rs = dao.logout(log);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("logout" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int updateUserInfo(ModelUser searchValue, ModelUser updateValue) {
        int rs = -1;
        try {
            rs = dao.updateUserInfo(searchValue, updateValue);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateUserInfo" + e.getMessage());
            throw e;
            
        }
        
        return rs;
    }
    
    @Override
    public int updatePasswd(String newPasswd, String currentPasswd,
            String userid) {
        int rs = -1;
        try {
            rs = dao.updatePasswd(newPasswd, currentPasswd, userid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updatePasswd" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        int rs = -1;
        try {
            rs = dao.deleteUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteUser" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelUser selectUserOne(ModelUser user) {
        ModelUser rs = null;
        try {
            rs = dao.selectUserOne(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectUserOne" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        List<ModelUser> rs = null;
        try {
            rs = dao.selectUserList(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectUserList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int checkuserid(String userid) {
        int rs = -1;
        try {
            rs = dao.checkuserid(userid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("checkuserid" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
