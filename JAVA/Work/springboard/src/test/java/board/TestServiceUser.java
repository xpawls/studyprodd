package board;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.inf.IServiceUser;
import board.model.ModelUser;
import board.service.ServiceUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceuser", ServiceUser.class);
        
        javax.sql.DataSource dataSource = (DataSource)context.getBean("dataSource");
        org.apache.ibatis.jdbc.ScriptRunner runner = new
        org.apache.ibatis.jdbc.ScriptRunner( dataSource.getConnection() );
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
        
        java.io.Reader br = new java.io.BufferedReader( new java.io.FileReader(sf) );
        runner.runScript( br);
        runner.closeConnection();
    }
    
    @Test
    public void test01_InsertUser() {
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
    public void test02_Login() {
        ModelUser user = new ModelUser();
        user.setUserid("dfsadf");
        user.setPasswd("bbbb");
        List<ModelUser> lis = null;
        lis = service.login(user);
        assertNotNull(lis);
    }
    
    @Test
    public void test03_Logout() {
        // fail("Not yet implemented");
    }
    
    @Test
    public void test04_UpdateUserInfo() {
        ModelUser searchValue = new ModelUser();
        searchValue.setUserno(2);
        searchValue.setUserid("dfadf");
        
        ModelUser updateValue = new ModelUser();
        updateValue.setName("test111");
        updateValue.setPasswd("password");
        
        int rs = service.updateUserInfo(searchValue, updateValue);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test05_UpdatePasswd() {
        
        int rs = -1;
        rs = service.updatePasswd("aaaaaaa", "bbbb", "dfsadf");
        assertNotEquals(-1, rs);
        
        
        
        
    }
    
    @Test
    public void test06_DeleteUser() {
        int rs = -1;
        ModelUser user = new ModelUser();
        user.setUserid("dfsadf");
        rs = service.deleteUser(user);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test07_SelectUserOne() {
        ModelUser lis = null;
        ModelUser user = new ModelUser();
        user.setUserno(1);
        lis = service.selectUserOne(user);
        assertEquals(1, (int)lis.getUserno());
    }
    
    @Test
    public void test08_SelectUserList() {
        ModelUser user = new ModelUser();
        user.setUserid("se");
        List<ModelUser> lis = null;
        lis = service.selectUserList(user);
        assertEquals(1, lis.size());
        
        
    }
    
    @Test
    public void test09_Checkuserid() {
        int rs = -1;
        rs = service.checkuserid("userid");
        assertEquals(1, rs);
    }
}
