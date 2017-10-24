package java18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ex18_05_Date {
    
    public static void main(String[] args) {
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String a = tf.format(from);
        System.out.println(a);
        
        int y = from.getYear();         System.out.println(y);
        int m = from.getMonth();        System.out.println(m);
        int d = from.getDate();         System.out.println(d);
        int h = from.getHours();        System.out.println(h);
        int mi = from.getMinutes();     System.out.println(mi);
        int s = from.getSeconds();      System.out.println(s);
        
        from.setYear(y+3);
        from.setMonth(m-4);
        from.setDate(d+2);
        from.setHours(h+4);
        from.setMinutes(mi-30);
        from.setSeconds(s+10);
        String aa = tf.format(from);
        System.out.println(aa);
        
        
        
        
        
        
    }
    
}
