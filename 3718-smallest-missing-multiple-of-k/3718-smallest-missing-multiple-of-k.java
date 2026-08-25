class Solution {
    public int missingMultiple(int[] nums, int k) {
       HashSet<Integer> l  = new HashSet<>();
       int count =0;

       for(int i=0;i<nums.length;i++){
          if(nums[i]%k==0){
            l.add(nums[i]);
            count++;
          }
       }

       int smallest = k;
       while(true){
          if(!l.contains(smallest)){
              return smallest;
          }
          smallest= smallest+k;
       }

      
       
    }
}