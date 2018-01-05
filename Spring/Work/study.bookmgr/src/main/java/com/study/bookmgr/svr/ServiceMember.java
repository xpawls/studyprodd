package com.study.bookmgr.svr;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.study.bookmgr.inf.IMember;
import com.study.bookmgr.inf.IServiceMember;
import com.study.bookmgr.model.ModelMember;

@Service("servicemember")
public class ServiceMember implements IServiceMember {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daomember")
    private IMember dao;
    
    @Override
    public List<ModelMember> selectAll() throws SQLException {
        List<ModelMember> rs = null;
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
    public List<ModelMember> selectLike(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        try {
            rs = dao.selectLike(member);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectLike" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelMember> selectEqual(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        try {
            rs = dao.selectEqual(member);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectEqual" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelMember> selectDynamic(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        try {
            rs = dao.selectDynamic(member);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectDynamic" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertMember(ModelMember member) throws SQLException {
        int rs = -1;
        try {
            rs = dao.insertMember(member);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertMember" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int updateMember(ModelMember wheremember, ModelMember setmemeber)
            throws SQLException {
        int rs = -1;
        try {
            rs = dao.updateMember(wheremember, setmemeber);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateMember" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteMember(ModelMember member) throws SQLException {
        int rs = -1;
        try {
            rs = dao.deleteMember(member);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteMember" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
