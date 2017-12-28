package aop;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ModelProduct;
import service.IServiceProduct;

public class TestFirstAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceProduct service;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        // classpath를 이용한 설정 파일 로딩
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop.xml");
        
        
        // file을 이용한 설정 파일 로딩
        // ApplicationContext context = new ClassPathXmlApplicationContext("주소");
        
        // DI를 이용한 servicebook 인스턴스 생성
        service =  context.getBean("svrprod", IServiceProduct.class);
    }
    
    @Test
    public void testGetProduct() {
        ModelProduct product = service.getProduct("bbb");
        assertTrue(1000 == product.getPrice());
        
    }
}
