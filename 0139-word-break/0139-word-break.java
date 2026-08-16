class Solution {

     HashSet<String> set ;

     boolean helper(String s, int start,int[] dp){
        if(start>=s.length()){
            return true;
        }

        if(dp[start]!=-1){
            return dp[start] == 1;
        }

        for(int end = start;end<s.length();end++){
             if(set.contains(s.substring(start,end+1))){
                 if (helper(s, end + 1,dp)){
                    dp[start]=1;
                    return true;
                 }
             }
        }
        
        dp[start] = 0;
        return false;

     }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
      set = new HashSet<>(wordDict);
      return helper(s,0,dp);
    }
}