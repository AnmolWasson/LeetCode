package GFG;
import java.util.*;
public class June7th {
    
class TNode{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
}


class LNode{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
}
}
    public TNode sortedListToBST(LNode head)
    {
        return BST(head);
        
    }
    
    TNode BST(LNode head){
        
        if(head==null||head.next==null){
           if(head==null)return null;
           
           return new TNode(head.data);
        }
        LNode mid=Mid(head);
        
        LNode crt=head;
        while(crt.next!=mid&&crt!=mid){
            crt=crt.next;
        }
        LNode nhead=mid.next;
        crt.next=null;
        mid.next=null;
        TNode root=new TNode(mid.data);
        
        root.left=BST(head);
        root.right=BST(nhead);
        
        return root;
    }
    
    
    LNode Mid(LNode root) {
        if (root == null || root.next == null)
            return root;
        LNode sl = root;
        LNode ft = root;

        while (ft != null && ft.next  != null) {
            sl = sl.next;
            ft = ft.next.next;
        }
        return sl;
    }



    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
       Arrays.sort(arr);
       
       ArrayList<Integer> ans=new ArrayList<>();
       for(int ele :arr){
           ans.add(ele);
       }
       
       return ans;
    }


    ArrayList <Integer> nearlySorted_02(int arr[], int num, int k)
    {
       
       
       PriorityQueue<Integer> que=new PriorityQueue<>();
       
       int idx=0,n=arr.length;
       ArrayList <Integer>ans=new ArrayList<>();
       for(int i=0;i<=k;i++){
           que.add(arr[idx++]);
          
       }
       
       while(idx<n&&que.size()>=k){
           if(!que.isEmpty()){
               ans.add(que.remove());
           }
           que.add(arr[idx++]);
       }
       while(!que.isEmpty())ans.add(que.remove());
       return ans;
    }


//Kadane's Algorithm 
    long maxSubarraySum(int arr[], int n){
        
        
        long crt =0, max=-(int)1e13;
        
        for(int i=0;i<n;i++){
            
            crt+=arr[i];
            max=Math.max(crt,max);
            if(crt<0)crt=0;
        }
        
        return max;
    }
}
