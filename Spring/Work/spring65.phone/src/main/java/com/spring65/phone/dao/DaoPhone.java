package com.spring65.phone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring65.phone.inf.IDaoPhone;
import com.spring65.phone.model.ModelPhone;

@Repository("daophone")
public class DaoPhone implements IDaoPhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone rs = null;
        rs = session.selectOne("mapper.mapperPhone.getPhoneOne", name);
        return rs;
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> rs = null;
        rs = session.selectList("mapper.mapperPhone.getPhoneList");
        return rs;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        int rs = -1;
        rs = session.insert("mapper.mapperPhone.insertPhone", phone);
        return rs;
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        int rs = -1;
        rs = session.insert("mapper.mapperPhone.insertPhoneList", phones);
        return rs;
    }
}
