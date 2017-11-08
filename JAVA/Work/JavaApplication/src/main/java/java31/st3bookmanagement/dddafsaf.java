package java31.st3bookmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dddafsaf {
    
    public static void main(String[] args) {
        MemberD me = new MemberD();
        
        List<MemberD> lis = new ArrayList<>();
        
        lis.add(new MemberD("gudska", "11111"));
        lis.add(new MemberD("sodu", "2222"));
        lis.add(new MemberD("sky", "11133"));
        lis.add(new MemberD("abcd", "11421"));
        lis.add(new MemberD("kundo", "11561"));
        
        
        for(int i=0; i<lis.size(); i++){
            if(lis.get(i).getMemID().equals("sky")){
                System.out.println(lis.get(i).getMemPW());
            } else {
                continue;
            }
        }
        
        List<MemberD> lis2 = new ArrayList<>();
        MemberD me2 = lis.get(2);
        
        lis2.add(me2);
        
        System.out.println(lis2.get(0).getMemID());

          
       
    }
    
    
}
