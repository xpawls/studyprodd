package java15.st4anonymous;

public class AnonymousTest {
    
    public static void main(String[] args) {
        
        TV tv1 = new TV();
        
        RemoteControl tv2 = new TV();
        
        RemoteControl tv3 = new RemoteControl() {
            
            @Override
            public void turnOn() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void turnOff() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void moveRight() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void moveLeft() {
                // TODO Auto-generated method stub
                
            }
        };
        
    }
    
}
