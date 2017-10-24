package java18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class jv18_05_Date {
    
    public static void main(String[] args) {
       Date date = null;
       date = new Date(114, 2, 18);
       System.out.println("Date(114, 2, 18)>> "+ date );
       
       date = new Date(114, 0, 18);
       System.out.println("Date(114, 0, 18)>> "+ date );
       
       date = new Date(114, 12, 18);
       System.out.println("Date(114, 12, 18)>> "+ date );
       
       
       Date from = new Date();
       SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String fo2 = tf.format(from);
       System.out.println(fo2);
       
       tf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       fo2 = tf.format(from);
       System.out.println(fo2);
       
    }
    
}
