
class Solution {

    void dfs(boolean[][] vis,int[][] grid,int i,int j,int n,int m){
        if(i<0 || i>=n || j< 0 || j>=m){
            return ;
        }

        if(grid[i][j]==0 || vis[i][j]==true){
            return;
        }

        vis[i][j]=true;

        dfs(vis,grid,i-1,j,n,m);
        dfs(vis,grid,i+1,j,n,m);
        dfs(vis,grid,i,j-1,n,m);
        dfs(vis,grid,i,j+1,n,m);
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        boolean[][] vis=new boolean[n][m];
        for(int j=0;j<m;j++){
             if(grid[0][j]==1){
                dfs(vis,grid,0,j,n,m);
             }
        }

         for(int j=0;j<m;j++){
             if(grid[n-1][j]==1){
                dfs(vis,grid,n-1,j,n,m);
             }
        }


       for(int i=0;i<n;i++){
             if(grid[i][0]==1){
                dfs(vis,grid,i,0,n,m);
             }
        }

        for(int i=0;i<n;i++){
             if(grid[i][m-1]==1){
                dfs(vis,grid,i,m-1,n,m);
             }
        }

        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;

        
    }
}