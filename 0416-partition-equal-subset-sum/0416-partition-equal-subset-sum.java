class Solution {
    boolean helper(int[] nums, int target, int i, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }
        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }
        boolean not_take = helper(nums, target, i + 1, dp);
        boolean take = false;

        if (nums[i] <= target) {
            take = helper(nums, target - nums[i], i + 1, dp);
        }

        boolean ans = take || not_take;

        dp[i][target] = ans ? 1 : 0;

        return ans;

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(nums, target, 0, dp);
    }
}