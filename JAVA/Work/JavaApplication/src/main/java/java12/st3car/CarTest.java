package java12.st3car;

public class CarTest {
    public static void main(String[] args){
        
        Car myCar = new Car();
        myCar.speedUp(100);
        myCar.speedPrint();
        System.out.println(myCar.toString());
        
        Car yourCar = new Car();
        yourCar.setColor("blue");
        yourCar.setSpeed(60);
        yourCar.setGear(3);
        System.out.println(yourCar.toString());
        Car car1 = new Car();
        System.out.println(car1.toString());
        car1 = yourCar;
        System.out.println(yourCar.toString());
        System.out.println(car1.toString());
        yourCar = myCar;
        System.out.println(yourCar.toString());
        System.out.println(car1.toString());
    }
}
