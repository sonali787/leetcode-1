class Solution {
    public int minimumDeletions(int[] nums) {
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        int mini_ind=0;
        int maxi_ind=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<mini){
                mini=nums[i];
                mini_ind=i;
            }
            if(nums[i]>maxi){
                maxi=nums[i];
                maxi_ind=i;
            }
        }

        int left = Math.max(mini_ind, maxi_ind) + 1;
        int right = Math.max(n - mini_ind, n - maxi_ind);

        int both = Math.min(
            mini_ind + 1 + n - maxi_ind,
            maxi_ind + 1 + n - mini_ind
        );

        return Math.min(left, Math.min(right, both));
    }
}