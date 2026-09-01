class Solution {
     void helper(boolean[][] vis,int[][] grid , int[] counter, int i,int j,int n,int m){
               
               if(i<0 || i>=n || j<0 || j>=m){
                   return;
               }
               
               if(vis[i][j] || grid[i][j]==0){
                return;
               }

               counter[0] = counter[0] + 1;
               vis[i][j] = true;

            helper(vis,grid,counter,i+1,j,n,m);
            helper(vis,grid,counter,i,j+1,n,m);
            helper(vis,grid,counter,i-1,j,n,m);
            helper(vis,grid,counter,i,j-1,n,m);

    }
    public int maxAreaOfIsland(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=false;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                     int[] counter = new int[1];
                      helper(vis,grid,counter,i,j,n,m);
                      res = Math.max(counter[0],res);
                }
              
            }
        }
        return res;
    }
}