class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] right_mini = new int[n];
        right_mini[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            right_mini[i]=Integer.min(right_mini[i+1],nums[i]);
        }

        int curr_maxi=0;

        for(int i=0;i<n;i++){
            curr_maxi=Integer.max(curr_maxi,nums[i]);
            int diff = curr_maxi-right_mini[i];

            if(diff<=k){
                return i;
            }
        }

        return -1;

    }
}