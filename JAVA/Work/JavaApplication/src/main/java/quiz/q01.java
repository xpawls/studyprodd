package quiz;

public class q01 {
    public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 

        String answer = getAnswer(strArr); 
        String question = getScrambledWord(answer); 

        System.out.println("Question:"+question); 
        System.out.println("Answer:"+answer); 
  } // main 

  public static String getAnswer(String[] strArr) { 
       int m = (int) (Math.random()*strArr.length);
       return strArr[m];
       
  } 
  
  public static String getScrambledWord(String str) { 
      
      char[] ch = str.toCharArray();
      for(int i=0; i<=ch.length*3;i++){
          int m = (int)(Math.random()*str.length());
          char tmp = ch[0]; 
          ch[0] = ch[m];
          ch[m] = tmp;
      }
      
      return new String(ch);
      
        // 내용을 완성하세요.
  } // scramble(String str) 


}
