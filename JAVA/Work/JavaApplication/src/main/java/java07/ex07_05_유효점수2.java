package java07;

public class ex07_05_유효점수2 {
    public static void main(String[] args){
        int[] score = {7,9,4,8,5};

        
        java.util.Arrays.sort(score);
        System.out.print("유효점수 : ");
        
        printArr(score);
        
        int sum = 0;
        
        for(int i=1; i<score.length-1; i++){
            sum = sum + score[i];
        }
        double ave = (double)sum/(score.length-2);
        System.out.println("합계 : "+sum);
        System.out.printf("평균 : %.2f", ave);
                
        
        
    }
    public static void printArr(int[] arr){
        for(int i=1; i<arr.length-1; i++){
            System.out.print(arr[i]);
            if(i==arr.length-2){
                System.out.println(".");
            } else {
                System.out.print(", ");
            }
        }
    }
}
