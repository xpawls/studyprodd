package java07;

import java.util.Scanner;

public class ex07_07_자리예약1차원 {
    public static void main(String[] args){
        int[] seat = new int[10];
        int sn = 0;
        Scanner keybo = new Scanner(System.in);
        for(;;){
            System.out.println("---------------------------------");
            System.out.println("  1  2  3  4  5  6  7  8  9 10  ");
            System.out.println("---------------------------------");
            for(int i = 0;i<seat.length; i++){
                System.out.print("  "+seat[i]);
            }
            System.out.println();
            System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1) : ");
            for (;;) {
                sn = keybo.nextInt();
                if(sn == -1){
                } else {
                    sn = sn-1;
                }
                if(sn>=0 && sn<=seat.length-1){
                    break;
                } else if (sn==-1){
                    break;
                } else {
                    System.out.println("존재하지 않는 좌석입니다.");
                }
            }
            
            if(sn==-1) { 
                break;
            }
            
            if(seat[sn]==0){
                seat[sn] = 1;
                System.out.println("예약되었습니다.");
            } else if(seat[sn]==1){
                System.out.println("이미 예약된 자리입니다.");
            }
            
        }
        
    }
    
}
