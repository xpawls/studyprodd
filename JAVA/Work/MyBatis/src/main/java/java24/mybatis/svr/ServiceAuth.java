package java24.mybatis.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java24.mybatis.inf.IAuth;
import java24.mybatis.inf.IServiceAuth;
import java24.mybatis.model.ModelAuth;

@Service("serviceauth")
public class ServiceAuth implements IServiceAuth {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoauth")
    private IAuth dao;

    @Override
    public int getCount(ModelAuth auth) throws Exception {
        int rs = -1;
        
        try {
            rs = dao.getCount(auth);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getCount" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int getMaxAuthid() throws Exception {
        int rs = -1;
        try {
            rs = dao.getMaxAuthid();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getMaxAuthid" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public List<ModelAuth> selectAll() throws Exception {
        List<ModelAuth> rs = null;
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
    public List<ModelAuth> selectLike(ModelAuth auth) throws Exception {
        List<ModelAuth> rs = null;
        try {
            rs = dao.selectLike(auth);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectLike" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public List<ModelAuth> selectEqual(ModelAuth auth) throws Exception {
        List<ModelAuth> rs = null;
        try {
            rs = dao.selectEqual(auth);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectEqual" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws Exception {
        int rs = -1;
        try {
            rs = dao.insertAuth(auth);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertAuth" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth)
            throws Exception {
        int rs = -1;
        try {
            rs = dao.updateAuth(whereauth, setauth);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateAuth" + e.getMessage());
            throw e;
            
        }
        
        return rs;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws Exception {
        int rs = -1;
        try {
            rs = dao.deleteAuth(auth);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteAuth" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
