package java13.st2methodtype;

public class MethodTypeTest {
    
    public static void main(String[] args) {
        
        MethodType m = new MethodType();
        
        // 인스턴스 메서드를 호출할 때는 인스턴스이름.메서드명
        m.instanceMethod();
        
        m.staticMethod();// 이 방법은 사용하지 말자.
        
        // static 메서드를 호출할 때는 클래스 이름.
        MethodType.staticMethod();
    }
    
}
