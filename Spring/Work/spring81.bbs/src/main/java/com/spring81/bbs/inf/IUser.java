package com.spring81.bbs.inf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring81.bbs.model.ModelUser;

public interface IUser {
    int insertUser(ModelUser user);
    ModelUser login(String userid, String passwd);
    int logout(String log);
    int updateUserInfo(ModelUser searchValue, ModelUser updateValue);
    int updatePasswd(String newPasswd, String currentPasswd, String userid);
    int deleteUser(ModelUser user);
    ModelUser selectUserOne(ModelUser user);
    List<ModelUser> selectUserList(ModelUser user);
    
    // id 종복 확인시 사용되는 메서드
    int checkuserid(String userid);
    
    // passwd 확인. 왜냐하면 패스워드는 암호화 되기 때문에...
    int checkpassword(String id, String curpw);
}
