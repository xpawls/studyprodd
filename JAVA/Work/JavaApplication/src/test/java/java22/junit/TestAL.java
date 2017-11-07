package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAL {
    private static List<String> emplist = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        emplist = new ArrayList<String>();
        emplist.add( "0" );
        emplist.add( "2" );
        emplist.add( "1" );
        emplist.add( "3" );
        emplist.add( "4" );
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test01() {
        assertNotNull(emplist);
    }
    
    @Test
    public void test02() {
        int s = emplist.size();
        assertEquals(5, s);
    }
    @Test
    public void test03() {
        for (String s : emplist) {
            assertNotEquals("10", s);
        }
        int result = emplist.indexOf("10");
        assertEquals(-1, result);
        
        boolean bo = emplist.contains("10");
        assertFalse(bo);
        
    }
    @Test
    public void test04() {
        String names[] = {"y2kpooh", "hwang"};
        String names2[] = {"y2kpooh", "hwang"};
        
        assertArrayEquals(names, names2);
    }
    
}
