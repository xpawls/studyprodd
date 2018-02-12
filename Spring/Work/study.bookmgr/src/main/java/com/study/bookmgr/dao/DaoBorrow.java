package com.study.bookmgr.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.study.bookmgr.inf.IBorrow;
import com.study.bookmgr.model.ModelBorrow;

@Repository("daoborrow")
public class DaoBorrow implements IBorrow {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public List<ModelBorrow> selectAll() throws SQLException {
        List<ModelBorrow> rs = null;
        rs = session.selectList("mapper.mapperBorrow.selectAll");
        return rs;
    }
    
    @Override
    public int insertBorrow(ModelBorrow borrow) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperBorrow.insertBorrow", borrow);
        return rs;
    }
    
    @Override
    public int deleteBorrow(ModelBorrow borrow) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperBorrow.deleteBorrow", borrow);
        return rs;
    }

    @Override
    public List<ModelBorrow> selectMemID(String memid) throws SQLException {
        return session.selectList("mapper.mapperBorrow.selectMemID", memid);
    }

    @Override
    public int brrbookY(int no) throws SQLException {
        return session.update("mapper.mapperBorrow.brrbookY", no);
    }

    @Override
    public int brrbookN(int no) throws SQLException {
        return session.update("mapper.mapperBorrow.brrbookN", no);
    }

    @Override
    public ModelBorrow selectBrrno(int brno) throws SQLException {
        return session.selectOne("mapper.mapperBorrow.selectBrrno", brno);
    }
}
