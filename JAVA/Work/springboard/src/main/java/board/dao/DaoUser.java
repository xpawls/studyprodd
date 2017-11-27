package board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import board.inf.IUser;
import board.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IUser {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public int insertUser(ModelUser user) {
        int rs = -1;
        rs = session.insert("mapper.mapperUser.insertUser", user);
        return rs;
    }

    @Override
    public List<ModelUser> login(ModelUser user) {
        List<ModelUser> lis = null;
        lis = session.selectList("mapper.mapperUser.login",user);
        return lis;
    }

    @Override
    public int logout(String log) {
        
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser searchValue, ModelUser updateValue) {
        int rs = -1;
        java.util.Map<String, ModelUser> map = new HashMap<>();
        map.put("searchValue", searchValue);
        map.put("updateValue", updateValue);
        rs = session.update("mapper.mapperUser.updateUserInfo", map);
        return rs;
    }

    @Override
    public int updatePasswd(String newPasswd, String currentPasswd,
            String userid) {
        int rs = -1;
        java.util.Map<String, String> map = new HashMap<>();
        map.put("newPasswd", newPasswd);
        map.put("currentPasswd", currentPasswd);
        map.put("userid", userid);
        rs = session.update("mapper.mapperUser.updatePasswd",map);
        return rs;
    }

    @Override
    public int deleteUser(ModelUser user) {
        int rs = -1;
        rs = session.update("mapper.mapperUser.deleteUser",user);
        return rs;
    }

    @Override
    public List<ModelUser> selectUserOne(ModelUser user) {
        List<ModelUser> lis = null;
        lis = session.selectList("mapper.mapperUser.selectUserOne", user);
        return lis;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        List<ModelUser> lis = null;
        lis = session.selectList("mapper.mapperUser.selectUserList", user);
        return lis;
    }

    @Override
    public int checkuserid(String userid) {
        int rs = -1;
        rs = session.selectOne("mapper.mapperUser.checkuserid", userid);
        return rs;
    }
}
