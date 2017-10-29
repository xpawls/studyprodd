package java04;

public class jv04_15_구구단가로출력 {
	public static void main(String[] args) {
		
		for(int i=2; i<=19; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%2d*%2d = %3d", i,j,i*j);
				if(j==9) {
					System.out.println(". ");
				} else {
					System.out.print(", ");
				}
			}
		}
	}

}
