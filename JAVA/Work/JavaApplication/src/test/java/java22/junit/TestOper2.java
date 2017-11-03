package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper2 {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_add() {
        Oper op = new Oper(5, 5);
        int r = op.Add();
        assertEquals(10, r);
    }
    
    @Test
    public void test_minus() {
        Oper op = new Oper(5, 5);
        int r = op.Minus();
        assertEquals(0, r);
    }
    
    @Test
    public void test_mul(){
        Oper op = new Oper(5, 5);
        int r = op.mul();
        assertEquals(25, r);
    }
    
    @Test
    public void test_Div(){
        Oper op = new Oper(5, 5);
        double r = op.Div();
        assertEquals(1.0, r,0.0);
    }
}
