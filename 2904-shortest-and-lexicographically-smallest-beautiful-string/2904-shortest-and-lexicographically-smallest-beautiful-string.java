class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int ones = 0, l = 0;
        String ans = "";

        for(int r =0;r<n;r++){
            if(s.charAt(r)=='1'){
                ones++;
            }

           if(ones==k){
            while(ones==k && s.charAt(l)=='0'){
                l++;
            }
            String curr_res = s.substring(l,r+1);
            if(ans.isEmpty()||curr_res.length()<ans.length() || (curr_res.length()==ans.length() && curr_res.compareTo(ans)<0)){
                ans=curr_res;
            }

            if(s.charAt(l)=='1'){
                l++;
                ones--;
            }
             
           }
        }

        return ans;
        

    }
}