package java18;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ex18_07_Calendar {
    
    public static void main(String[] args) {
        //Calendar 클래스를 이용하여 프로그램을 작성하시오.
        Calendar d = Calendar.getInstance();
        //현재 날짜와 시간 출력
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(tf.format(d.getTime()));
        //현재 연도만 출력
        System.out.println(d.get(Calendar.YEAR));
        System.out.println(d.get(Calendar.MONTH));
        System.out.println(d.get(Calendar.DATE));
        System.out.println(d.get(Calendar.HOUR));
        System.out.println(d.get(Calendar.MINUTE));
        System.out.println(d.get(Calendar.SECOND));
        
        
        
    }
    
}
