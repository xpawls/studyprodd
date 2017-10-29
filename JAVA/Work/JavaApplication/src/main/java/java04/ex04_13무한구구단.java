package java04;

import java.util.Scanner;

public class ex04_13무한구구단 {
	public static void main(String[] args) {
		int s, e;
		
		Scanner key = new Scanner(System.in);
		for(;;) {
			System.out.print("시작값을 입력(1이하 입력시 종료): ");
			s= key.nextInt();
			System.out.print("종료값을 입력 (1이하 입력시 종료): ");
			e= key.nextInt();
			if(s<=1 || e<=1) {
				System.out.println("올바르지 않은 값을 입력하여 종료합니다.");
				break;
			}
			
			if(s>e) {
				int tmp = s;
				s = e;
				e = tmp;
			} else {
				
			}
			for(int i=s; i<=e; i++) {
				for(int j=1; j<=9; j++) {
					System.out.printf("%3d*%d=%4d", i,j,i*j);
					if(j==9) {
						System.out.println(".");
					} else {
						System.out.print(", ");
					}
				}
			}
		}
	}

}
