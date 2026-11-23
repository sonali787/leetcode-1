class Solution {
    public List<Integer> getRow(int r) {
        
        List<Integer> ans = new ArrayList<>();

       ans.add(1);
       long prev =1;
       for(int i=1;i<=r;i++){
         prev = prev * (r-i+1) / i;
         ans.add((int)prev);
       }
     
       return ans;
    }
}