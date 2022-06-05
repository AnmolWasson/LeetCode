
package DailyProblems;
public class RollingHash{

  public static void main(String[] args) {
      
    String str="AABAACBAA";
    String pat="BCA";
    System.out.println(hash(str,pat));
  }
    static boolean hash(String txt,String pat){

        int d=26,p=5381,hpat=0,tpat=0;

        for(int i=0;i<pat.length();i++){

        
            hpat*=d;
            hpat=hpat+((pat.charAt(i)-'A'+1)%p);

        }

           int si=0,ei=0;
          
           while(ei<txt.length()){
                   
            tpat*=d;
            tpat=tpat+(txt.charAt(ei)-'A'+1)%p;
            ei++;

            if(ei-si==pat.length()){
                if(tpat==hpat){
                   if(match(txt,pat,si,ei)){
                      return true;
                   }
                }
                tpat=tpat-(txt.charAt(si)-'A'+1)*(int)Math.pow(26,ei-si-1);
                si++;
            }
           }
           return false;
    }

    static boolean match(String s1,String s2,int si,int ei){
  

        for(int i=si;i<ei;i++){
            if(s1.charAt(i)!=s2.charAt(i-si)){
                return false;
            }
        }
        return true;
    }


   
}