package java04;

public class jv04_12_구구단가로출력 {
    
    public static void main(String[] args){
        
        int sum = 0 ;
        
        for(int i =2; i<=19; i=i+1){
            
            //줄바꿈을 넣을 수 있는 곳 1
            
            for(int j =1; j<=9; j=j+1){
                
                sum = i*j;
                
                if(j<9){
                    System.out.printf(" %2d x %2d =%3d, ", i,j,sum);
                } else {
                    System.out.printf(" %2d x %2d =%3d. ", i,j,sum);
                }
                
            }
            //줄바꿈을 넣을 수 있는 곳 2
            
            System.out.println();
            
        }
    }
}
