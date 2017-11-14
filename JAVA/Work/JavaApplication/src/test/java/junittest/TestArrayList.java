package junittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestArrayList {
    static List<String> elist = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        elist = new ArrayList<String>();
        elist.add("0");
        elist.add("2");
        elist.add("1");
        elist.add("3");
        elist.add("4");
        
    }
    
    @Test
    public void test01() {
        assertNotNull(elist);
       
    }
    

    @Test
    public void test02() {
        assertEquals(5, elist.size());
    }
    

    @Test
    public void test03() {
        for (String string : elist) {
            assertNotEquals("10",string);
        }
    }
    

    @Test
    public void test04() {
        String name1[] = {"y2kpooh","hwang"};
        String name2[] = {"y2kpooh","hwang"};
        
        assertArrayEquals(name1, name2);
    }
    
}
