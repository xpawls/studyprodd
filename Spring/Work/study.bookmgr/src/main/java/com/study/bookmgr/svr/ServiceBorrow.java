package com.study.bookmgr.svr;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.study.bookmgr.inf.IBorrow;
import com.study.bookmgr.inf.IServiceBorrow;
import com.study.bookmgr.model.ModelBorrow;

@Service("serviceborrow")
public class ServiceBorrow implements IServiceBorrow {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoborrow")
    private IBorrow dao;
    
    @Override
    public List<ModelBorrow> selectAll() throws SQLException {
        List<ModelBorrow> rs = null;
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
    public int insertBorrow(ModelBorrow borrow) throws SQLException {
        int rs = -1;
        try {
            rs = dao.insertBorrow(borrow);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBorrow" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteBorrow(ModelBorrow borrow) throws SQLException {
        int rs = -1;
        try {
            rs = dao.deleteBorrow(borrow);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteBorrow" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public List<ModelBorrow> selectMemID(String memid) throws SQLException {
        List<ModelBorrow> rs = null;
        
        try {
            rs = dao.selectMemID(memid);
        } catch (Exception e) {
            logger.error("selectMemID" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int brrbookY(int no) throws SQLException {
        int rs = -1;
        try {
            rs = dao.brrbookY(no);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrbookY" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int brrbookN(int no) throws SQLException {
        int rs = -1;
        try {
            rs = dao.brrbookN(no);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrbookN" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public ModelBorrow selectBrrno(int brno) throws SQLException {
        ModelBorrow rs = null;
        try {
            rs = dao.selectBrrno(brno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectBrrno" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
