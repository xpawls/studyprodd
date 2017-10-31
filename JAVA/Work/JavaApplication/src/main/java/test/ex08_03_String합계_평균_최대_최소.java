package test;

public class ex08_03_String합계_평균_최대_최소 {
    
    public static void main(String[] args) {
        String n = "74 784 9883 73 9 73646 774";
        String[] ns = n.split(" ");
        int [] ia = new int[ns.length];
        int sum = 0;
        for(int i=0; i<ns.length; i++){
            ia[i] = Integer.valueOf(ns[i]);
            sum += ia[i];
        }
        java.util.Arrays.sort(ia);
        System.out.println("합계 : "+sum);
        System.out.println("평균 : "+(double)sum/ns.length);
        System.out.println("최대값 : "+ia[ia.length-1]);
        System.out.println("최소값 : "+ia[0]);
        
        
    }
    
}
