package com.spring65.phone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;
import com.spring65.phone.svr.ServicePhone;

public class TestServicePhone {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static IServicePhone service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        
        service = context.getBean("servicephone", ServicePhone.class);
    }
    
    @Test
    public void test01_getPhoneOne() {
        ModelPhone rs = null;
        
        rs = service.getPhoneOne("ppp");
        assertEquals("gagaga", rs.getManufacturer());
        
    }
    @Test
    public void test02_getPhoneList() {
        List<ModelPhone> rs = null;
        rs = service.getPhoneList();
        assertEquals(6, rs.size());
    }
    @Test
    public void test03_insertPhone() {
        ModelPhone phone = new ModelPhone("bbbb", "tata", 8000);
        int rs = -1;
        rs = service.insertPhone(phone);
        assertTrue(rs>=0);
        
    }
    @Test
    public void test04_insertPhoneList() {
        List<ModelPhone> list = new ArrayList<>();
        ModelPhone phone = new ModelPhone("ccc", "baba", 4000);
        list.add(phone);
        phone = new ModelPhone("dddd", "taaq", 8888);
        list.add(phone);
        phone = new ModelPhone("nnnn", "raar", 9000);
        list.add(phone);
        
        int rs = -1;
        rs = service.insertPhoneList(list);
        
        assertTrue(rs>=0);
        
        
    }
}
