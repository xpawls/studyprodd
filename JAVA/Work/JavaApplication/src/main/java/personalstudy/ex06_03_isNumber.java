package personalstudy;

import java.util.Scanner;

public class ex06_03_isNumber {
	public static void main(String[] args) {
		Scanner keybo = new Scanner(System.in);
		String[] str = new String[5];
		
		for(int i=0; i<str.length; i++) {
			System.out.print("배열문장"+i);
			str[i] = keybo.next();
		}
		
		boolean is = isNumber(str);
		
		System.out.println(is);
		
		
		
	}
	public static boolean isNumber(String[] num) {
		boolean b = true;
		char c = 0;
		for(int i=0; i<num.length; i++) {
			if(num[i]==null||num[i]=="") {
				b = false;
				break;
			} else {
				b = true;
				c = num[i].charAt(0);
			}
			if(c>='0'&& c<='9') {
				b = true;
			} else {
				b = false;
				break;
			}
			
		}
		return b;
		
	}

}
