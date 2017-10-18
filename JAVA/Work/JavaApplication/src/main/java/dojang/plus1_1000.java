package dojang;

public class plus1_1000 {
    public static void main(String[] args){
        int sum = 0;
        
        for(int i=1; i<1000; i++){
            if(i%3==0 || i%5==0){
                sum += i;
            } else {
                
            }
        }
        System.out.println(sum);
        
    }
}
