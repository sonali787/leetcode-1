class pair{
    int i;
    int j;
    pair(int i,int j){
        this.i =i;
        this.j = j;
    }
}
class Solution {
    
    void dfs(char[][] grid,int i,int j,int n,int m,boolean[][] vis){
        if(i<0 || i>=n || j<0 || j>=m){
          return;
        }

        if(grid[i][j]=='0' || vis[i][j]==true){
           return;
        }
        vis[i][j]=true;
        
        dfs(grid,i,j+1,n,m,vis);
        dfs(grid,i,j-1,n,m,vis);
        dfs(grid,i+1,j,n,m,vis);
        dfs(grid,i-1,j,n,m,vis);

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    q.add(new pair(i,j));
                }
            }
        }

        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=false;
            }
        }

        int count=0;
        while(!q.isEmpty()){
            pair ele = q.poll();
            int i=ele.i;
            int j=ele.j;

            if(vis[i][j]==false){
                count = count+1;
                dfs(grid,i,j,n,m,vis);
            }

        }


        return count;



    }
}