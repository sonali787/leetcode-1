class Solution {
    int helper(int[] nums,int ind,int prev,int n,int[][] dp){
        if(prev==n || ind == n) {
            return 0;
        }


        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int not_take = helper(nums,ind+1,prev,n,dp);
        int take =0;
          if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + helper(nums, ind + 1, ind, n,dp);
        }
        
        return dp[ind][prev+1] = Integer.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums,0,-1,n,dp);
    }
}