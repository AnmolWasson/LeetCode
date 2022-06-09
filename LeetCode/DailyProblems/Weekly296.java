import java.util.*;
public class Weekly296{


//     public int partitionArray(int[] nums, int k) {
        
        
//         Arrays.sort(nums);
//         int n=nums.length;
        
        
//         LinkedList<Integer> st=new LinkedList<>();
//         st.addLast(nums[0]);
//            for(int i=1;i<n;i++){
               
               
//                if(nums[i]-st.getLast()>k){
//                    st.addLast(nums[i]);
//                }
//            }
        
        
//         return st.size();
//     }
    
    
    
    
public int partitionArray(int[] nums, int k) {
         
         
    int n=nums.length;
       
       Arrays.sort(nums);
       
       int count=1,idx=0;
       
       
       for(int i=0;i<n;i++){
           
           if(nums[i]-nums[idx]>k){
               count++;
               idx=i;
           }
       }
       
       return count;
       
   }

}