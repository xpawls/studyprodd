package java04;

public class jv04_03_삼각형출력_역 {
    
    public static void main(String[] args){
        
        for(int i = 1; i<=10;i=i+1){
            for(int j = 10; j>=i; j=j-1){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
