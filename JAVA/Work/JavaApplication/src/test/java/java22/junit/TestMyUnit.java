package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyUnit {
    private static Myunit myUnit = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        myUnit = new Myunit();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testConcate() {
        String tc = myUnit.concate("ab", "12");
        assertEquals("ab12", tc);
        
    }
    
    @Test
    public void testGetBoolean() {
        boolean b = myUnit.getBoolean();
        assertFalse(b);
        assertTrue(!b);
        assertEquals(b, false);
        assertSame(b, false);
        
    }
    
    @Test
    public void testgetSameObject() {
        Object result = myUnit.getObject();
        assertNull(result);
        assertEquals(null, result);        
        assertSame(null, result);
        assertNull(myUnit.getSameObject());
        
    }
    @Test
    public void testgetObject() {
        Object result = myUnit.getObject();
        assertNull(result);
        assertEquals(null, result);        
        assertSame(null, result);
        assertSame(null, myUnit.getObject());
    }
    @Test
    public void testgetStringArray() {
        String[] result = myUnit.getStringArray();
        
        String[] sa = {"one", "two", "three"};
        assertArrayEquals(sa, result);
        assertArrayEquals(myUnit.getStringArray(),sa);
        
    }
    @Test(expected = ArithmeticException.class)// 예외처리 - exception 처리(.class 빠지면 안돼)
    public void testgetException() {
        double result = myUnit.getException(); // ArithmeticException 발생.
        
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testgetEmptyList() {
        ArrayList<String> list = myUnit.getEmptyList();
        list.get(0);
        
    }
    
}
