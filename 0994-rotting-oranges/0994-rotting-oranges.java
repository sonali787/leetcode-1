class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Node> q = new LinkedList<>();
        int fresh =0;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Node(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};
        int count=0;
        while(!q.isEmpty()){
          int size=q.size();
          
           for(int p=0;p<size;p++){

            Node node = q.poll();
            int i = node.x;
            int j = node.y;

            for(int k=0;k<4;k++){
                int next_row=dir[k][0]+i;
                int next_col=dir[k][1]+j;
                if(next_row<0 || next_row>=n || next_col < 0 || next_col >= m || grid[next_row][next_col]==0){
                    continue;
                }

                if(grid[next_row][next_col]==2){
                    continue;
                }

                fresh--;
                grid[next_row][next_col]=2;
                q.add(new Node(next_row,next_col));

            }
           }
            if (q.size() != 0) {
                count++;
            }
        }

        if(fresh!=0){
            return -1;
        }

        return count;



    }
}