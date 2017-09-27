package java06;

public class ex06_02_inputVal {
    public static void main(String[] args){
        
        int[] d = {4,5,6,9,7,13};
        String p = "eee";

        
        String[] st = input(d,p);
        
        
        for(int i = 0; i<st.length; i++){
            System.out.print(st[i]+", ");
            
        }
        
    }
    
    public static String[] input(int[] a, String re){
        
        
        String[] out = new String[a.length*2];
        
        for(int i=0; i<a.length; i++){
            out[i] = Integer.toString(a[i]);
        }
        out[a.length+1] = re;
        return out;
        
        
    }

}
