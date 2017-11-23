package java24.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java24.mybatis.inf.IAuth;
import java24.mybatis.model.ModelAuth;

@Repository("daoauth")
public class DaoAuth implements IAuth {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public int getCount(ModelAuth auth) throws Exception {
        int result = 0;
        result = session.selectOne("mapper.mapperAuth.getCount", auth);
        return result;
    }

    @Override
    public int getMaxAuthid() throws Exception {
        int result = 0;
        result = session.selectOne("mapper.mapperAuth.getMaxAuthid");
        return result;
    }

    @Override
    public List<ModelAuth> selectAll() throws Exception {
        List<ModelAuth> rs = null;
        rs = session.selectList("mapper.mapperAuth.selectAll");
        return rs;
    }

    @Override
    public List<ModelAuth> selectLike(ModelAuth auth) throws Exception {
        List<ModelAuth> rs = null;
        rs = session.selectList("mapper.mapperAuth.selectLike", auth);
        return rs;
    }

    @Override
    public List<ModelAuth> selectEqual(ModelAuth auth) throws Exception {
        List<ModelAuth> rs = null;
        rs = session.selectList("mapper.mapperAuth.selectEqual", auth);
        return rs;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws Exception {
        int rs = -1;
        rs = session.insert("mapper.mapperAuth.insertAuth", auth);
        return rs;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth)
            throws Exception {
        int rs = -1;
        Map<String, ModelAuth> map = new HashMap<>();
        map.put("whereauth", whereauth);
        map.put("setauth", setauth);
        rs = session.update("mapper.mapperAuth.updateAuth", map);
        return rs;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws Exception {
        int rs = -1;
        rs = session.delete("mapper.mapperAuth.deleteAuth",auth);
        return rs;
    }
}
