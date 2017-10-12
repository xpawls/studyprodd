package java12.st3car;

public class CarTest {
    public static void main(String[] args){
        
        Car myCar = new Car();
        myCar.speedUp(100);
        myCar.speedPrint();
        System.out.println(myCar.toString()+"numberofCars = "+myCar.getNumberOfCars());
        
        
        Car yourCar = new Car();
        yourCar.setColor("blue");
        yourCar.setSpeed(60);
        yourCar.setGear(3);
        
        System.out.println(yourCar.toString()+"numberofCars = "+yourCar.getNumberOfCars());
        
        
        Car otherCar = new Car("blue", 60, 3);
        System.out.println(otherCar.toString()+"numberofCars = "+otherCar.getNumberOfCars());
        
        System.out.println("------------------------");
        System.out.println(myCar.toString()+"numberofCars = "+myCar.getNumberOfCars());
        System.out.println(yourCar.toString()+"numberofCars = "+yourCar.getNumberOfCars());
        System.out.println(otherCar.toString()+"numberofCars = "+otherCar.getNumberOfCars());
    }
}
