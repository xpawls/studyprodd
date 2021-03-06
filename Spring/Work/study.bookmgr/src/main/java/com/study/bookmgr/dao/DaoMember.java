package com.study.bookmgr.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.study.bookmgr.inf.IMember;
import com.study.bookmgr.model.ModelMember;

@Repository("daomember")
public class DaoMember implements IMember {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public List<ModelMember> selectAll() throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectAll");
        return rs;
    }

    @Override
    public List<ModelMember> selectLike(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectLike", member);
        return rs;
    }

    @Override
    public List<ModelMember> selectEqual(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectEqual", member);
        return rs;
    }

    @Override
    public List<ModelMember> selectDynamic(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectDynamic", member);
        return rs;
    }

    @Override
    public int insertMember(ModelMember member) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperMember.insertMember", member);
        return rs;
    }

    @Override
    public int updateMember(ModelMember wheremember, ModelMember setmemeber)
            throws SQLException {
        int rs = -1;
        Map<String, ModelMember> map = new HashMap<>();
        map.put("wheremember", wheremember);
        map.put("setmemeber", setmemeber);
        rs = session.insert("mapper.mapperMember.updateMember", map);
        return rs;
    }

    @Override
    public int deleteMember(ModelMember member) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperMember.deleteMember", member);
        return rs;
    }

    @Override
    public int newID(String memID) throws SQLException {
        int rs = -1;
        rs = session.selectOne("mapper.mapperMember.newID", memID);
        return rs;
    }

    @Override
    public ModelMember Login(String memID, String memPW) throws SQLException {
        ModelMember rs = null;
        Map<String, String> map = new HashMap<>();
        
        map.put("memID", memID);
        map.put("memPW", memPW);
        
        rs = session.selectOne("mapper.mapperMember.Login", map);
        return rs;
    }
}
