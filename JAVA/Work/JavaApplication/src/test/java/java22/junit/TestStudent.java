package java22.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudent {
    private static Student student = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        student = new Student();
    }
    
    
    @Test
    public void test_getgrade() {
        for(int i=90; i<=100; i++){
            assertEquals("A", student.getgrade(i));
            assertSame("A", student.getgrade(i));
        }
        for(int i=80; i<90; i++){
            assertEquals("B", student.getgrade(i));
            assertSame("B", student.getgrade(i));
        }
        for(int i=70; i<80; i++){
            assertEquals("C", student.getgrade(i));
            assertSame("C", student.getgrade(i));
        }
        for(int i=60; i<70; i++){
            assertEquals("D", student.getgrade(i));
            assertSame("D", student.getgrade(i));
        }
        for(int i=0; i<60; i++){
            assertEquals("F", student.getgrade(i));
            assertSame("F", student.getgrade(i));
        }
        assertNotEquals("A", student.getgrade(101));
        assertEquals("A",    student.getgrade(95));
        assertSame("B",      student.getgrade(86));
        assertNotSame("B",   student.getgrade(79));
        assertEquals("D",    student.getgrade(66));
        assertEquals("F",    student.getgrade(52));

        
    }
}
