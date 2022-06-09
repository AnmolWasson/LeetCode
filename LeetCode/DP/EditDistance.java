public class EditDistance {
    


    // Basic version 


    public int editDistance(String s, String t) {
       
       
        //   return editDistance_rec(s,t,0,0);
        
        // int n=s.length(),m=t.length();
           
        //   int [][]dp=new int[n+1][m+1];
           
        //   for(int i=0;i<=n;i++){
        //       Arrays.fill(dp[i],-1);
        //   }
           
        //   return editDistance_memo(s,t,0,0,dp);
        
        return editDist_tabu(s,t);
        }
        
        
        int editDistance_rec(String s ,String t,int  si,int ei){
            
            
            int  n=s.length(),m=t.length();
            if(si==n||ei==m){
                return si==n?m-ei:n-si;
            }
            
            int insert=editDistance_rec(s,t,si,ei+1);
            int delete=editDistance_rec(s,t,si+1,ei);
            int replace=editDistance_rec(s,t,si+1,ei+1);
            
            if(s.charAt(si)!=t.charAt(ei)){
                
                return Math.min(insert,Math.min(delete,replace))+1;
            }
            
            else{
                return replace;
            }
        }
        
        int editDistance_memo(String s ,String t,int  si,int ei,int[][]dp){
            
            
            int  n=s.length(),m=t.length();
            if(si==n||ei==m){
                return dp[si][ei]=si==n?m-ei:n-si;
            }
            
            
            if(dp[si][ei]!=-1)return dp[si][ei];
            int insert=editDistance_memo(s,t,si,ei+1,dp);
            int delete=editDistance_memo(s,t,si+1,ei,dp);
            int replace=editDistance_memo(s,t,si+1,ei+1,dp);
            
            if(s.charAt(si)!=t.charAt(ei)){
                
                return dp[si][ei]=Math.min(insert,Math.min(delete,replace))+1;
            }
            
            else{
                return dp[si][ei]=replace;
            }
        }
        
        
        int editDist_tabu(String s,String t){
            
            int n=s.length(),m=t.length();
            
            int [][] dp=new int[n+1][m+1];
            
            
            for(int i=n;i>=0;i--){
                
                
                for(int j=m;j>=0;j--){
                    
                    if(i==n||j==m){
                        dp[i][j]= (i==n?m-j:n-i);
                        continue;
                    }
                    
                    if(s.charAt(i)==t.charAt(j)){
                        dp[i][j]=dp[i+1][j+1];
                    }
                    
                    else{
                        dp[i][j]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i+1][j+1])+1;
                    }
                }
            }
            
            return dp[0][0];
        }



        ////////////////////////////////////////////////////////



        // Variation 
        // if there is a cost of insertion , deletion and replacement

        // insert=2, delete = 5, replace=3;

int cost[]={2,5,3};
        public int editDistance_02(String s, String t,int cost[]) {
             

            return  editDistance_02_rec(s,t,0,0,cost);
        }


        int editDistance_02_rec(String s, String t, int si,int ei,int []cost){
            

            int n=s.length,m=t.length;
            if(si==n||ei==m){

              return si==n?(m-ei)*cost[0]:(n-si)*cost[1]; 
            }

               int insert=editDistance_02_rec(s,t,si,ei+1,cost);

               int delete=editDistance_02_rec(s,t,si+1,ei,cost);

               int replace=editDistance_02_rec(s,t,si+1,ei+1,cost);


               if(s.charAt(si)==t.charAt(ei)){
                     return replace;
               }

               else{
return Math.min(insert+cost[0],Math.min(delete+cost[1],replace+cost[2]));
               }
        }
}
