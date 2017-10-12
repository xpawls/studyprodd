package java12;

import java.util.Scanner;

import java12.st1rect.Rect;

public class RectTest {
    public static void main(String [] args){
        
        Rect re = new Rect();
        int w, h;
        Scanner key = new Scanner(System.in);
        
        System.out.print("가로 입력 : ");
        w = key.nextInt();
        System.out.print("세로 입력 : ");
        h = key.nextInt();
        
        re.setWidth(w);
        re.setHeight(h);
        
        System.out.println("사각형의 면적은 : " + re.getArea());
        System.out.println("사각형의 둘레는 : " + re.getPerimeter());
        
        
    }
}
