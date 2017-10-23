package java16.product;

import java.util.Scanner;

public class ProductInfo2 {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        
        int n = 0, s = 0, id = 0, price = 0, is = 0;
        int bookn =0, cd =0, conbook=0;
        String pe, pr, name = null, au = null, lang = null;
        
        Book[] boo = new Book[10];
        CompactDisc[] com = new CompactDisc[10];
        ConversationBook[] cvb = new ConversationBook[10];
        for(;;){
            System.out.print("상품 추가<1>. 모든상품조회<2>, 끝내기<3>>>>");
            n = key.nextInt();
            if(n==1 && id<=10){//상품추가
                
                System.out.print("상품 종류 책<1>, 음악CD<2>, 회화책<3>>>>");
                s = key.nextInt();
                if(s==1 || s == 2||s==3){// 책 음악
                    System.out.print("상품 설명>>");//pe
                    pe = key.next();
                    System.out.print("생산자>>");//pr
                    pr = key.next();
                    System.out.print("가격>>");//p
                    price = key.nextInt();
                    if(s==1 || s==3){// 책 회화책
                        System.out.print("책제목>>");//name
                        name = key.next();
                        System.out.print("저자>>");//au
                        au = key.next();
                        if(s==3) {//회화책
                            System.out.print("언어>>");//lang
                            lang = key.next();
                        }
                        System.out.print("ISBN>>");//is
                        is = key.nextInt();
                    } else if (s==2){// 음악cd
                        System.out.print("앨범 제목>>");//name
                        name = key.next();
                        System.out.print("가수>>");//au
                        au = key.next();
                    }
                    
                    if(s==1){
                        boo[bookn] =new Book(id, pe, pr, price, is, au, name);
                        bookn++;
                    } else if (s==2) {
                        com[cd] = new CompactDisc(id, pe, pr, price, name, au);
                        cd++;
                    } else if (s==3) {
                        cvb[conbook] = new ConversationBook(id, pe, pr, price, is, au, name, lang);
                        conbook++;
                    }
                    
                    id++;
                } // 상품추가 끝
            } else if (n==1 && id>10){
                System.out.println("더 이상 상품을 추가할 수 없습니다.");
                continue;
            } else if (n==2) {//모든상품조회
                if (bookn>0){
                    for(int i=1; i<=bookn; i++){
                        System.out.println(boo[i-1].toString());
                        System.out.println("========================");
                    }
                } else {
                    
                }
                if (cd>0){
                    for(int i=1; i<=cd; i++){
                        System.out.println(com[i-1].toString());
                        System.out.println("========================");   
                    }
                } else {
                    
                }
                if (conbook>0){
                    for(int i=1; i<=conbook; i++){
                        System.out.println(cvb[i-1].toString());
                        System.out.println("========================");
                    }
                } else {
                    
                }
            } else if (n==3) {//끝내기
                break;
            } else {
                System.out.println("1~3사이의 수를 입력하십시오");
                continue;
            }
        }
    }
    
}
