package board;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.inf.IServiceUser;
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
        
    }
    
    @Test
    public void testLogin() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testLogout() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateUserInfo() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdatePasswd() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteUser() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectUserOne() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectUserList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testCheckuserid() {
        fail("Not yet implemented");
    }
}
