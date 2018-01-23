package com.exam08.hn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPhone implements IDaoPhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public ModelPhone getPhoneOne(String name) {
        return session.selectOne("mapperPhone.getPhoneOne", name);
    }

    @Override
    public List<ModelPhone> getPhoneList(int start, int end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        return session.selectList("mapperPhone.getPhoneList", map);
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mapperPhone.insertPhone", phone);
    }


    @Override
    public int getPhoneTotalRecord() {
        return session.selectOne("mapperPhone.getPhoneTotalRecord");
    }
}
