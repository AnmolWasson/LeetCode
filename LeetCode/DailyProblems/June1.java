package DailyProblems;

public class June1 {
    
}

public class June1{
int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
public int closedIsland(int[][] grid) {
    
    
    int n=grid.length,m=grid[0].length;
    // mark the boundaries
    
    for(int i=0;i<n;i++){
        
        for(int j=0;j<m;j++){
            
            if(i==0||i==n-1||j==0||j==m-1){
                
                if(grid[i][j]==0){
                    dfs_01(i,j,grid);
                }
            }
            
        }
    }
    
    int count=0;
     for(int i=0;i<n;i++){
        
        for(int j=0;j<m;j++){
            
       
            if(grid[i][j]==0){
                count++;
                dfs_02(i,j,grid);
            }
            
        }
         
     }
    
     for(int i=0;i<n;i++){
        
        for(int j=0;j<m;j++){
      
            
            if(grid[i][j]==-1)grid[i][j]=0;
        }
         
     }
    
    return count;
    
}

void dfs_01(int si,int sj,int[][]grid){
    
    grid[si][sj]=-1;
      int n=grid.length,m=grid[0].length;
    
    for(int d=0;d<dir.length;d++){
        
        int r=si+dir[d][0];
        int c=sj+dir[d][1];
        
        if(r>=0&&r<n&&c>=0&&c<m&&grid[r][c]==0){
            
            dfs_01(r,c,grid);
        }
    }
}



void dfs_02(int si,int sj,int[][]grid){
    
    grid[si][sj]=-1;
    
     int n=grid.length,m=grid[0].length; 
    for(int d=0;d<dir.length;d++){
        
        int r=si+dir[d][0];
        int c=sj+dir[d][1];
        
        if(r>=0&&r<n&&c>=0&&c<m&&grid[r][c]==0){
            
            dfs_02(r,c,grid);
        }
    }
}


}