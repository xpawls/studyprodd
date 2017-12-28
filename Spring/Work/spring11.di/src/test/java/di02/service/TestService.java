package di02.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di02.ISearchEngine;
import di02.SearchEngine;
import di02.Type;

public class TestService {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("service.xml");
        
        Type pdfType = (Type) context.getBean("pdfType");
        
        assertEquals("PDF", pdfType.getName());
        assertEquals("Portable Document", pdfType.getDesc());
        assertEquals(".pdf", pdfType.getExtension());
        
        di02.Type webType = (Type) context.getBean("webType");
        assertEquals("WEB", webType.getName());
        assertEquals("WEB link", webType.getDesc());
        assertEquals(".url", webType.getExtension());
        
        di02.Document doc1 = context.getBean("doc1", di02.Document.class);
        assertEquals("Book", doc1.getName());
        assertEquals("/book/Book.pdf", doc1.getLocation());
        assertEquals(pdfType, doc1.getType());
        
        // di02.ISearchEngine engine = new SearchEngine();
        
        di02.ISearchEngine engine = context.getBean("engine", ISearchEngine.class);
        assertEquals(2,  engine.listAll().size());
    }
}
