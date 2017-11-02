package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper {
    
    
    
    @Test
    public void testAdd() {
        // Oper 클래스의 인스턴스 생성
        Oper op = new Oper(2, 4);
        
        int rs = op.Add();
        assertEquals(6, rs);
    }
    
    @Test
    public void testMinus(){
        
        Oper op = new Oper(2, 4);
        
        int rs = op.Minus();
        assertEquals(-2, rs);
    }
    
    @Test
    public void testMul(){
        
        Oper op = new Oper(2, 4);
        
        int rs = op.mul();
        assertEquals(8, rs);
    }
    
    @Test
    public void testDiv(){
        
        Oper op = new Oper(3,5);
        double aa = 0.6;
        double rs = op.Div();
        assertEquals(aa, rs,1e-6);
    }
    
}
