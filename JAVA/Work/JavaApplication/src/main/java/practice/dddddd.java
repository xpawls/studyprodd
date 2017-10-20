package practice;

public class dddddd {
    public static void main(String[] args){
        
        String prov= "abc defg ijklm nop qrs wx yz";
        
        int j = prov.length();
        
        String sub = prov.substring(4, 8);
        
        prov =  prov.replace("ijk", "*#$%^");
        
        System.out.println(j);
        System.out.println(sub);
        System.out.println(prov);
        
        String ss = "74 874 9883 73 9 73646 774";
        
        String[] cc = ss.split(" ");
        
        int[] arr = new int[cc.length];
        for(int i=0; i<cc.length;i++){
            
            arr[i] = Integer.valueOf(cc[i]);
        }
        java.util.Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
        
    }
}
