package java24.mybatis;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.inf.IServiceBook;
import java24.mybatis.model.ModelBook;
import java24.mybatis.svr.ServiceBook;

public class TestServiceBook {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceBook service = null;
    
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
    public void testGetCount() throws Exception {
        ModelBook book = new ModelBook();
        int rs = service.getCount(book);
        assertEquals(4, rs);
        
    }
    
    @Test
    public void testGetMaxBookid() throws Exception {
        int rs = service.getMaxBookid();
        assertEquals(4, rs);
        
    }
    
    @Test
    public void testSelectAll() throws Exception {
        List<ModelBook> rs = service.selectAll();
        assertNotNull(rs);
        assertEquals(5, rs.size());
    }
    
    @Test
    public void testSelectLike() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("%my%");
        List<ModelBook> rs = service.selectLike(book);
        String result = rs.get(0).getBookname();
        assertEquals("mysql", result);
    }
    
    @Test
    public void testSelectEqual() throws Exception {
        ModelBook book = new ModelBook();
        book.setPublisher("hall");
        List<ModelBook> rs = service.selectEqual(book);
        String name = rs.get(0).getBookname();
        assertEquals("java", name);
    }
    
    @Test
    public void testInsertBook() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("cva");
        book.setPublisher("bsab");
        int result = service.insertBook(book);
        assertNotEquals(-1, result);
        assertEquals(5, result);
    }
    
    @Test
    public void testInsertMap() throws Exception {
        int result = service.insertMap("c", java.sql.Date.valueOf("2017-11-08"), 5);
        assertNotEquals(-1, result);
        assertEquals(8, result);
    }
    
    @Test
    public void testUpdateBook() throws Exception {
        ModelBook wh = new ModelBook();
        wh.setBookname("c++");
        ModelBook set = new ModelBook();
        set.setAuthid(6);
        int result = service.updateBook(wh, set);
        assertNotEquals(-1, result);
        
        
    }
    
    @Test
    public void testDeleteBook() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("c++");
        int result = service.deleteBook(book);
        assertNotEquals(-1, result);
        
    }
    
    @Test
    public void testSelectDynamic() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        List<ModelBook> result = service.selectDynamic(book);
        String pub = result.get(0).getPublisher();
        assertEquals("oreilly", pub);
        
    }
}
