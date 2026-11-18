class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected_sum = n * (n+1)/2;

        int curr_sum =0;
        for(int i=0;i<n;i++){
            curr_sum = curr_sum + nums[i];
        }

        return expected_sum - curr_sum;
    }
}