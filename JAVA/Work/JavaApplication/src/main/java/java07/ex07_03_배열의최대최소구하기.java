package java07;

public class ex07_03_배열의최대최소구하기 {
    public static void main(String[] args){
        
        int [] array = {23,96,35,42,81,19,8,77,50,64};
        System.out.print("배열 정렬 전 : ");
        printArray(array);
        
        java.util.Arrays.sort(array);
        
        System.out.print("배열 정렬 후 : ");
        printArray(array);
        
        int max = array[array.length-1];
        int min = array[0];
        System.out.println("최대값 : " +max);
        System.out.println("최소값 : " +min);
        
    }
    
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            if (i==arr.length-1){
                System.out.print(". ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
