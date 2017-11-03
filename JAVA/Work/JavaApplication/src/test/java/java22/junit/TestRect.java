package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRect {
    private static Rect re = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass ");
        re = new Rect(6, 10);
    }
    
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }
    
    @Test
    public void test() {
        
        int a = re.area();
        assertNotEquals(456, a);
        assertEquals(60, a);
        assertTrue(60==a);
        assertFalse(80==a);
        
    }
    
    @Test
    public void test_p(){
        
        int p = re.perimeter();
        assertNotEquals(456, p);
        assertEquals(32, p);
    }
    
    @Test
    public void test_type(){
        Object r = re.type();
        
        assertNull(r);
    }
}
