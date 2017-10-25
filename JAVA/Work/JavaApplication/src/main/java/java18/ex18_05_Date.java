package java18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ex18_05_Date {
    
    public static void main(String[] args) {
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String a = tf.format(from);
        System.out.println(a);
        // 현재 연도만 출력
        tf = new SimpleDateFormat("yyyy");
        System.out.println(tf.format(from));
        // 현재 월만 출력
        tf = new SimpleDateFormat("MM");
        System.out.println(tf.format(from));
        // 현재 일만 출력
        tf = new SimpleDateFormat("dd");
        System.out.println(tf.format(from));
        // 현재 시간만 출력
        tf = new SimpleDateFormat("HH");
        System.out.println(tf.format(from));
        // 현재 분만 출력
        tf = new SimpleDateFormat("mm");
        System.out.println(tf.format(from));
        // 현재 초만 출력
        tf = new SimpleDateFormat("ss");
        System.out.println(tf.format(from));
        
        System.out.println(from.getYear());
        System.out.println(from.getMonth());
        System.out.println(from.getDate());
        System.out.println(from.getHours());
        System.out.println(from.getMinutes());
        System.out.println(from.getSeconds());
        
        /* 현재에 +3년, -4월, +2일, +4시간, -30분, +10초를 추가하고
         *  "yyyy-MM-dd", "HH:mm:ss"의 형태로 출력하시오.
         */
        from.setYear(from.getYear()+3);
        from.setMonth(from.getMonth()-4);
        from.setDate(from.getDate()+2);
        from.setHours(from.getHours()+4);
        from.setMinutes(from.getMinutes()-30);
        from.setSeconds(from.getSeconds()+10);
        tf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(tf.format(from));
        tf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(tf.format(from));
        
        
        
        
        
        
    }
    
}
