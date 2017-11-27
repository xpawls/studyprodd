package board;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.inf.IServiceUser;
import board.model.ModelUser;
import board.service.ServiceUser;

public class TestServiceUser {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceuser", ServiceUser.class);
    }
    
    @Test
    public void testInsertUser() {
        int rs = -1;
        ModelUser user  = new ModelUser();
        user.setUserid("dfsadf");
        user.setName("asdaasd");
        user.setEmail("adfasd");
        user.setPasswd("bbbb");
        rs = service.insertUser(user);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testLogin() {
        ModelUser user = new ModelUser();
        user.setUserid("dfsadf");
        user.setPasswd("bbbb");
        List<ModelUser> lis = null;
        lis = service.login(user);
        assertNotNull(lis);
    }
    
    @Test
    public void testLogout() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateUserInfo() {
        ModelUser searchValue = new ModelUser();
        searchValue.setUserno(1);
        searchValue.setUserid("dfadf");
        
        ModelUser updateValue = new ModelUser();
        updateValue.setName("test111");
        updateValue.setPasswd("password");
        
        int rs = service.updateUserInfo(searchValue, updateValue);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testUpdatePasswd() {
        
        int rs = -1;
        rs = service.updatePasswd("aaaaaaa", "bbbb", "dfsadf");
        assertNotEquals(-1, rs);
        
        
        
        
    }
    
    @Test
    public void testDeleteUser() {
        int rs = -1;
        ModelUser user = new ModelUser();
        user.setUserid("dfsadf");
        rs = service.deleteUser(user);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testSelectUserOne() {
        List<ModelUser> lis = null;
        ModelUser user = new ModelUser();
        user.setUserno(1);
        lis = service.selectUserOne(user);
        assertEquals(1, lis.size());
    }
    
    @Test
    public void testSelectUserList() {
        ModelUser user = new ModelUser();
        user.setUserid("sa");
        List<ModelUser> lis = null;
        lis = service.selectUserList(user);
        assertEquals(1, lis.size());
        
        
    }
    
    @Test
    public void testCheckuserid() {
        int rs = -1;
        rs = service.checkuserid("dfsadf");
        assertEquals(1, rs);
    }
}
