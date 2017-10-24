package java16.product;

public class Test {
    
    public static void main(String[] args) {
        int random = (int)(Math.random()*100);//1
        System.out.println(random);
        String gn = "082-2-777-5566";//2
        String nn = gn.substring(0, 3);
        System.out.println(nn);
        String cn = gn.substring(4, 5);
        System.out.println(cn);
        String con = gn.substring(6);
        System.out.println(con);
        
        
        
        int random1 = (int)(Math.random()*10)+1;//5
        System.out.println(random1);
        
        String s = "By doubting we come at the truth";//6
        String[] sar = s.split(" ");
    }
    
}
