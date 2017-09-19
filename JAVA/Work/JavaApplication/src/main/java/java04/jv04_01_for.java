package java04;

public class jv04_01_for {
    
    public static void main(String [] args){
        
        for(int i = 0; 
                      i<=10 ;
                             i=i+1 ){
            
            System.out.println( i );
        }
        
        int sum = 0;
        for(int i=0; 
                    i<=10 ;
                            i=i+1){
            sum = sum + i;
        }
        // 합계 출력
        System.out.println("합은"+sum);
        
        sum = 0;
        
        for(int i=1; i<=10 ; i=i+1){
            sum = sum + i;
            System.out.println("1부터 " + i + "까지의 합 : " + sum );
        }
    }
    
}
