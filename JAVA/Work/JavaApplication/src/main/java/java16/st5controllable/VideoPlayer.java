package java16.st5controllable;

public class VideoPlayer implements controllable {
    
    @Override
    public void play() {
        System.out.println("play");
        
    }
    
    @Override
    public void stop() {
        System.out.println("stop");
        
    }
    
}
