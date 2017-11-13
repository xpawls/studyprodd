package junittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRect {
    private static Rect rt = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        rt = new Rect(5, 10);
    }
    
    @Test
    public void testArea() {
        int rs = rt.area();
        assertEquals(50, rs);
        assertNotEquals(40, rs);
        assertTrue(rs==50);
        assertFalse(rs!=50);
    }
    
    @Test
    public void testPerimeter() {
        int rs = rt.perimeter();
        assertEquals(30, rs);
        assertNotEquals(40, rs);
        assertTrue(rs==30);
        assertFalse(rs!=30);
        
    }
    
    
}
