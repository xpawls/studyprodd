package java07;

import java.util.Scanner;

public class ex07_06_숨겨진카드 {
    public static void main(String[] args){
        Scanner keybo = new Scanner(System.in);
        
        for(;;){//게임준비
            int ans = (int)(Math.random()*99);
            int max = 99;
            int min = 0;
            String yn;
            String[] str = {"y","n"};
            System.out.println("수를 결정하였습니다. 맞추어 보세요");
            
            for(int i=1; true; i++){//게임시작
                System.out.printf("%d~%d%n", min,max);
                System.out.print(i+">>");
                int a = keybo.nextInt();
                if(ans>a){//정답보다 숫자가 작으면
                    System.out.println("더 높게");
                    if(min<a){//최저점수가 입력값보다 작으면 입력값을 넣는다
                        min = a;
                    } else {//최저점수가 입력값보다 크면 통과한다
                        
                    }
                } else if(ans<a) {//정답보다 숫자가 크면
                    System.out.println("더 낮게");
                    if(max>a){//최대점수가 입력값보다 크면 입력값을 넣는다
                        max = a;
                    } else {//최대점수가 입력값보다 작으면 통과
                        
                    }
                } else if (ans==a) {//입력값이 정답이라면 break
                    System.out.println("맞았습니다.");
                    break;
                }
                
            }
            for(;;){
                System.out.println("다시하시겠습니까?(y/n)");
                
                yn = keybo.next();
                if(yn.equals(str[1])||yn.equals(str[0])){
                    break;
                }
            }
            if(yn.equals(str[1])){
                break;
            }
            
      
       }
    }     
}
