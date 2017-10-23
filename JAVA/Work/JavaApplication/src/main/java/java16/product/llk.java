package java16.product;

public class llk {
    
    public static void main(String[] args) {
        
        String s = "74 874 9883 73 9 73646 774";
        int sum = 0;
        String[] sa = s.split(" ");
        int[] ia = new int[sa.length];
        for(int i=0; i<sa.length; i++){
            ia[i] = Integer.valueOf(sa[i]);
            sum += ia[i];
        }
        int avg = sum/ia.length;
        
        System.out.printf("sum = %d, avg = %d ", sum,avg);
        
    }
    
}
