class Solution {

    void dfs(int[][] grid,int n,int i,boolean[] vis){
       if(vis[i]==true){
        return;
       }

       vis[i]=true;

       for(int j=0;j<n;j++){
          if(vis[j]==false && grid[i][j]==1){
             dfs(grid,n,j,vis);
          }
       }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;

        boolean[] vis = new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(isConnected,n,i,vis);
                count++;
            }
        }

        return count;
    }
}