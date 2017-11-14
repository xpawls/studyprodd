package junittest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyUnit {
    private static MyUnit my = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        my = new MyUnit();
    }
    
    @Test
    public void testConcate() {
        String string = "1234";
        String string2 = "abcd";
        String result = my.concate(string, string2);
        
        assertEquals("1234abcd", result);
        assertNotNull(result);
        assertFalse(result.equals(null));
        assertTrue(result.equals("1234abcd"));
    }
    
    @Test
    public void testGetBoolean() {
        boolean result = my.getBoolean();
        boolean fal = false;
        assertFalse(result);
        assertEquals(fal, result);
    }
    
    @Test
    public void testGetSameObject() {
        Object result = my.getSameObject();
        assertEquals(null, result);
        assertNull(result);
        assertTrue(result==null);
    }
    
    @Test
    public void testGetObject() {
        Object result = my.getObject();
        Object ob = null;
        Object ob2 = "";
        assertEquals(null, result);
        assertSame(ob, result);
        assertNull(result);
        assertNotEquals(ob2, result);
    }
    
    @Test
    public void testGetStringArray() {
        String[] result = my.getStringArray();
        String[] sarr = {"one", "two", "three"};
        assertArrayEquals(sarr, result);
        assertNotNull(result);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testGetException()  {
        my.getException();
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmptyList() {
        ArrayList<String> result = my.getEmptyList();
        assertNull(result.get(0));
    }
    
}
