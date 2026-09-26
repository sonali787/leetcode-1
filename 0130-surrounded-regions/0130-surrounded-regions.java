 class Node{
    int i;
    int j;
    Node(int i,int j){
        this.i=i;
        this.j=j;
    }
 }

class Solution {
    public void solve(char[][] board) {
          
          int n = board.length;
          int m = board[0].length;

          Queue<Node> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                q.add(new Node(i, 0));
                board[i][0] = 'V';
            }

            if (board[i][m - 1] == 'O') {
                q.add(new Node(i, m - 1));
                board[i][m - 1] = 'V';
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                q.add(new Node(0, j));
                board[0][j] = 'V';
            }

            if (board[n - 1][j] == 'O') {
                q.add(new Node(n - 1, j));
                board[n - 1][j] = 'V';
            }
        }
          int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
          while (!q.isEmpty()) {

            Node curr = q.poll();

            int row = curr.i;
            int col = curr.j;

            for (int i = 0; i < 4; i++) {

                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = 'V';
                    q.add(new Node(nr, nc));
                }
            }
        }

        // Convert surrounded O's to X
        // Restore safe O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }



    }
}