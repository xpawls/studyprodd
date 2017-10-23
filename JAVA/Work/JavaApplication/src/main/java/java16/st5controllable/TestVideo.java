package java16.st5controllable;

public class TestVideo {
    
    public static void main(String[] args) {
        
        
        
        controllable cv = new VideoPlayer(){
            @Override
            public void play() {
                // TODO Auto-generated method stub
                super.play();
            }
            @Override
            public void stop() {
                // TODO Auto-generated method stub
                super.stop();
            }
        };
        cv.play();
        cv.stop();
        
        
        
    }
    
}
