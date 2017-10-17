package java14.st3car;

public class SportsCarTest {
    
    public static void main(String[] args) {
        
        SportsCar ts = new SportsCar();
        ts.setColor("white");
        ts.setGear(6);
        ts.setSpeed(250);
        ts.setTurbo(true);
        
        SportsCar c2 = new SportsCar(300, 5, "green", true);
        
        //생성자를 이용한 초기화 : turbo 설정
        SportsCar c3 = new SportsCar(true);
        
      // 매개변수 2개짜리 생성자 만드시오 : color, turbo
        SportsCar c4 = new SportsCar("black", true);
        System.out.println(ts.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        
        
    }
    
}
