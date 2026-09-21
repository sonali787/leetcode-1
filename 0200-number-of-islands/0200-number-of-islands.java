class Node{
    int i;
    int j;

    Node(int i,int j){
        this.i=i;
        this.j=j;
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
        boolean[][] vis=new boolean[n][m];

        Queue<Node> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    q.add(new Node(i,j));
                }
            }
        }
        int count=0;

        while(!q.isEmpty()){
            Node curr_node = q.poll();
            int i=curr_node.i;
            int j=curr_node.j;

            if(vis[i][j]==false){
                dfs(grid,i,j,n,m,vis);
                                count++;
            }
        }

        return count;
    }
}