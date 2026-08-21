class Solution {
    public int helper(String str1,String str2,int ind1,int ind2,int[][] dp){

        if(ind1>=str1.length()||ind2>=str2.length()){
            return 0;
        }

        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }

        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return dp[ind1][ind2]=1 + helper(str1,str2,ind1+1,ind2+1,dp);
        }

        return dp[ind1][ind2]=Math.max(helper(str1,str2,ind1+1,ind2,dp),helper(str1,str2,ind1,ind2+1,dp));

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i=0;i<=n;i++){
          for(int j=0;j<=m;j++){
            dp[i][j]=-1;
          }
        }
        return helper(text1,text2,0,0,dp);
    }
}