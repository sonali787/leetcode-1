class Solution {
    int helper(int[] coins,int i , int n , int target,int[][] dp) {
        if(target==0){
            return 1;
        }
        if(i >= n || target < 0) {
            return 0;
        }

        if(dp[i][target]!=-1){
            return dp[i][target];
        }
    
        int take =  helper(coins,i,n,target-coins[i],dp);
        int not_take = helper(coins,i+1,n,target,dp);

        return dp[i][target]=take + not_take;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        return helper(coins,0,n,amount,dp);
    }
}