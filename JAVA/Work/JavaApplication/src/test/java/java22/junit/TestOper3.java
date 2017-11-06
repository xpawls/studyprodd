package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import practice.opop;

public class TestOper3 {
    private static Oper op = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        op = new Oper(4,2);
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testadd() {
        int result = op.Add();
        assertEquals(6, result);
        assertSame(6, result);
        assertTrue(result==6);
    }
    @Test
    public void testmin() {
        int result = op.Minus();
        assertEquals(2, result);
        assertSame(2, result);
        assertFalse(result!=2);
        
    }
    @Test
    public void testmul() {
        int result = op.mul();
        assertEquals(8, result);
        assertSame(8, result);
        assertNotNull(result);
    }
    @Test
    public void testdiv() {
        double result = op.Div();
        assertEquals(2, result, 0);
        assertNotNull(result);
        
    }
    
    
}
