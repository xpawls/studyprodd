package com.exam08.hn;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPhone {
    private static IServicePhone service = null;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service  = context.getBean(IServicePhone.class);
    }
    
    
    @Test
    public void test01_GetPhoneList() {
        List<ModelPhone> result = service.getPhoneList(1,80);
        
        // 인스턴스 검증
        assertNotNull(result);
        
        // 값 검증
        assertEquals("name", result.get(0).getName());
    }
    @Test
    public void test02_GetPhoneOne() {
        ModelPhone result = service.getPhoneOne("name");
        

        // 인스턴스 검증
        assertNotNull(result);
        
        // 값 검증
        assertEquals("name", result.getName());
    }
    
    
    @Test
    public void test03_InsertPhone() {
        ModelPhone phone = new ModelPhone();
        phone.setManufacturer("test");
        phone.setName("test");
        phone.setPrice(10);
        
        int result = service.insertPhone(phone);
        
        assertTrue(result == 1);
    }
}
