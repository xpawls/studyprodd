package java07;

public class jv07_01_array {
    
    public static void main(String[] args){
        
        // 변수 5개 선언
        int score1 =1, score2 =2, score3 =3, score4 =4, score5 =5;
        
        // 배열을 이용한 변수 5개 선언.
        int [] score = new int[5]; 
        score[0] = 0; //score0층에 정수 0을 넣는다
        score[1] = 1; //score1층에 정수 0을 넣는다
        score[2] = 2; //score2층에 정수 0을 넣는다
        score[3] = 3; //score3층에 정수 0을 넣는다
        score[4] = 4; //score4층에 정수 0을 넣는다
        
        // 출력
        System.out.println("score1 : "+score1);
        
        System.out.println("score[0] : " +score[0]);
    }
    
}
