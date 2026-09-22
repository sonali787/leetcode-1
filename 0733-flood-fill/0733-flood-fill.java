class Solution {
    void dfs(int[][] image,int i,int j,boolean[][] vis,int n,int m,int org_color){

        if(i< 0 || i>=n || j<0 || j>=m){
            return;
        }

        if(image[i][j]!=org_color || vis[i][j]== true){
           return;
        }

        vis[i][j]=true;

        dfs(image,i-1,j,vis,n,m,org_color);
        dfs(image,i+1,j,vis,n,m,org_color);
        dfs(image,i,j-1,vis,n,m,org_color);
        dfs(image,i,j+1,vis,n,m,org_color);


    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] vis = new boolean[n][m];
        int org_color=image[sr][sc];

        dfs(image,sr,sc,vis,n,m,org_color);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==true){
                    image[i][j]=color;
                }
            }
        }

        return image;
    }
}