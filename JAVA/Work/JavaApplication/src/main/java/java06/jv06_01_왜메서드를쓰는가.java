package java06;

public class jv06_01_왜메서드를쓰는가 {
    public static void main(String[] args){
        
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        // 1부터 10까지의 합계를 구하고
        // 그 합계를 sum에 저장하고 sum 값을 출력한다

        for(int i =1; i<=10; i++){
           sum = sum+i;
            
        }
        System.out.println(sum);
        
        // 1부터 100까지의 합계를 구하고 
        // 그 합계를 sum2에 저장하고 sum2 값을 출력한다
        
        for(int i =1; i<=100; i++){
           sum2 = sum2+i;
        }
        System.out.println(sum2);
        
        // 100부터 sum2까지의 합계를 구하고
        // 그 합계를 sum3에 저장하고sum3 값을 출력한다
        for(int i =100; i<=sum2; i++){
            sum3 = sum3+i;
        }
        System.out.println(sum3);
    }
}
