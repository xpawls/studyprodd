package junittest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudent {
    private static Student st = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        st = new Student();
    }
    
    @Test
    public void testGetgrade() {
        for(int i=0;i<60; i++){
            assertEquals("F", st.getgrade(i));
        }
        for(int i=60;i<70; i++){
            assertEquals("D", st.getgrade(i));
        }
        for(int i=70;i<80; i++){
            assertEquals("C", st.getgrade(i));
        }
        for(int i=80;i<90; i++){
            assertEquals("B", st.getgrade(i));
        }
        for(int i=90;i<101; i++){
            assertEquals("A", st.getgrade(i));
        }
        
    }
    
}
