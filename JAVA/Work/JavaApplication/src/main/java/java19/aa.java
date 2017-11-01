package java19;

import java.util.StringTokenizer;

public class aa {
    public static void main(String[] args){
        StringTokenizer a = new StringTokenizer("1 + 2 - 1 = 5", "+-= ");
        
        while(a.hasMoreTokens()){
            System.out.print(a.nextToken()+" ");
        }
    }
 
    
        
}
