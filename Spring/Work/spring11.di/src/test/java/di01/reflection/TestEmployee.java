package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import di01.model.Employee;

public class TestEmployee {
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Test
    public void test_make_instance_with_new() {
        
        di01.model.Employee emp1 = new Employee();
        emp1.setAddress("emp1 address");
        emp1.setName("emp1 name");
        emp1.setRnn("emp1 rnn");
        emp1.setSalary(100000);
        assertEquals("emp1 address", emp1.getAddress());
        
        Employee emp2 = new Employee("emp2 name", 100000, "emp2 address", "emp2 rnn");
        assertEquals("emp2 address", emp2.getAddress());
    }
    
    @Test
    public void test_make_instance_with_reflection() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // reflection을 이용해서 인스턴스 만들기.
        // reflection으로 new di01.model.Employee("emp2 name", 100000, "emp2 address", "emp2 rnn");
        Class klass = Class.forName("di01.model.Employee");
        
        // 생성자 메서드의 매개변수 타입 선언.
        Class [] paramTypes = {String.class, Integer.class, String.class, String.class};
        
        // 매개변서 값 설정.
        Object[] objs = {"emp2 name", 100000, "emp2 address", "emp2 rnn"};
        
        //생성자 메서드 가져오기.
        java.lang.reflect.Constructor cons = klass.getConstructor(paramTypes);
        
        // 인스턴스 만들기
        Object instance = cons.newInstance(objs);
        
        System.out.println(instance.toString());
        assertEquals("emp2 address", ((di01.model.Employee)instance).getAddress());
        
        
        /*
         * setter를 이용하여 필드값 바꾸기
         */
        
        Method m = klass.getMethod("setName", String.class);
        
        // 매개변서 값 설정
        Object [] params = {"hello"};
        
        // 메서드 호출
        m.invoke(instance, params);

        assertEquals("hello", ((di01.model.Employee)instance).getName());
        
        /*
         * getter를 이용하여 필드값 가져오기
         */ 
        m = klass.getMethod("getName");
        Object result = m.invoke(instance);
    }
}
