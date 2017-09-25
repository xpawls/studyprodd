package java06;

public class jv06_02_왜메서드를쓰는가 {
    
    public static int getSum(int start, int end){
        
        int sum =0;
        
        for(int i =start; i<=end; i=i+1){
            sum = sum + i;
        }
        
        return sum;
    }
    public static void main(String[] args){
        // 1부터 10까지의 합계를 구하고
        // 그 합계를 sum에 저장하고 sum 값을 출력한다
        int sum = getSum( 1, 10 );
        System.out.println(sum);
        
        // 1부터 100까지의 합계를 구하고 
        // 그 합계를 sum2에 저장하고 sum2 값을 출력한다
        
        int sum2 = getSum( 1, 100 );
        System.out.println(sum2);
        
        // 100부터 sum2까지의 합계를 구하고
        // 그 합계를 sum3에 저장하고sum3 값을 출력한다
        int sum3 = getSum( 100, sum2);
        System.out.println(sum3);
    }
}
