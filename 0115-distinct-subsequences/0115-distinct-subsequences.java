class Solution {
    int helper(String s,String t,int i,int j,int n,int m,int[][] dp){

        if(j>=m){
            return 1;
        }
        if(i>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==t.charAt(j)){
            int take = helper(s,t,i+1,j+1,n,m,dp);
            int not_take=helper(s,t,i+1,j,n,m,dp);
            return dp[i][j]=take+not_take;

        }
           return dp[i][j]=helper(s,t,i+1,j,n,m,dp);

    }
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return helper(s,t,0,0,n,m,dp);
        
    }
}