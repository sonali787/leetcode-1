class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> l = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                l.add(nums[i]);

            }
        }

        int smallest = k;
        while (l.contains(smallest)) {
            smallest += k;
        }

        return smallest;

    }
}