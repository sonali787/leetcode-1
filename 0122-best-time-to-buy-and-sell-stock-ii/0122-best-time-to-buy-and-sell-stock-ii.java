class Solution {

    int helper(int[] prices,int i, boolean canBuy,int[][] dp){
        if(i==prices.length){
            return 0;
        }
       
        if(canBuy==true){

            if(dp[i][0]!=-1){
                return dp[i][0];
            }
            int buy = helper(prices,i+1,false,dp) - prices[i];
            int skip = helper(prices,i+1,true,dp);
            return dp[i][0]=Integer.max(buy,skip);
        }else{

            if(dp[i][1]!=-1){
                return dp[i][1];
            }
           int sell = helper(prices,i+1,true,dp)+prices[i];
           int skip= helper(prices,i+1,false,dp);

           return dp[i][1]=Integer.max(sell,skip);

        }

    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(prices,0,true,dp);
    }
}