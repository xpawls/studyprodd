package java24.mybatis;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.svr.ServiceBook;

public class TestServiceBook {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ServiceBook service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        // classpath를 이용한 설정 파일 로딩
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        
        // file을 이용한 설정 파일 로딩
        // ApplicationContext context = new ClassPathXmlApplicationContext("주소");
        
        // DI를 이용한 servicebook 인스턴스 생성
        service = context.getBean("servicebook", ServiceBook.class);
    }
    
    @Test
    public void testGetCount() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetMaxBookid() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectAll() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectLike() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectEqual() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertMap() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectDynamic() {
        fail("Not yet implemented");
    }
}
