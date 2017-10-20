package java16.product;

import java.util.Scanner;

public class ProductInfo2 {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        
        int n = 0;
        int s = 0;
        int i = 0;
        Product pro = new Product();
        
        for(;;){
            System.out.print("상품 추가<1>. 모든상품조회<2>, 끝내기<3>>>>");
            n = key.nextInt();
            if(n==1 && i<=10){//상품추가
                
                System.out.print("상품 종류 책<1>, 음악CD<2>, 회화책<3>>>>");
                s = key.nextInt();
                if(s==1 || s == 2||s==3){// 책 음악
                    System.out.print("상품 설명>>");
                    System.out.print("생산자>>");
                    System.out.print("가격>>");
                    
                    if(s==1 || s==3){// 책 회화책
                        System.out.print("책제목>>");
                        System.out.print("저자>>");
                        if(s==3) {//회화책
                            System.out.print("언어>>");
                        }
                    } else if (s==2){// 음악cd
                        System.out.print("앨범 제목>>");
                        System.out.print("가수>>");
                    }
                    System.out.print("ISBN>>");
                } // 상품추가 끝
            } else if (n==2) {//모든상품조회
                
            } else if (n==3) {//끝내기
                break;
            } else {
                System.out.println("1~3사이의 수를 입력하십시오");
                continue;
            }
        }
    }
    
}
