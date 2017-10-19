package java16.st2interface;

public class Fridge implements RemoteControl {
    
    @Override
    public void turnOn() {
        System.out.println("Fridge.turnOn");
    }
    
    @Override
    public void turnOff() {
        System.out.println("Fridge.turnOff");
    }

    @Override
    public void moveLeft() {
        System.out.println("Fridge.moveLeft");
    }

    @Override
    public void moveRight() {
        System.out.println("Fridge.moveRight");
    }
    
}
