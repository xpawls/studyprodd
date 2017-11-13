package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper {
    private static Oper op = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        op = new Oper(3, 5);
    }
    
    @Test
    public void testAdd() {
        int rs = op.add();
        assertEquals(8, rs);
        assertNotEquals(6, rs);
        assertTrue(rs==8);
        assertFalse(rs==6);
        assertNotNull(rs);
    }
    
    @Test
    public void testMinus() {
        int rs = op.minus();
        assertEquals(-2, rs);
        assertNotEquals(2, rs);
        assertTrue(rs==-2);
        assertFalse(rs==2);
        assertNotNull(rs);
    }
    
    @Test
    public void testMul() {
        int rs = op.mul();
        assertEquals(15, rs);
        assertNotEquals(10, rs);
        assertTrue(rs==15);
        assertFalse(rs==12);
        assertNotNull(rs);
    }
    
    @Test
    public void testDiv() {
        double rs = op.div();
        assertEquals(0.6, rs, 0);
        assertNotEquals(0, rs);
        assertTrue(rs==0.6);
        assertFalse(rs!=0.6);
        
    }
    
}
