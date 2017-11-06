package 김형남;

public class ex2 {
    
    public static void main(String[] args) {
        int[] iarr = {23, 96, 35, 42, 81, 19, 8, 77, 50};
        
        System.out.print("정렬전 : ");
        for (int i : iarr) {
            System.out.print(i+ " ");
        }
        
        java.util.Arrays.sort(iarr);
        
        System.out.println();
        
        System.out.print("정렬후 : ");        
        for (int i : iarr) {
            System.out.print(i+ " ");
        }
    }
    
}
