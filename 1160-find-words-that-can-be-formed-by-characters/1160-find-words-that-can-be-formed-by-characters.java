class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];

        for(int i = 0;i<chars.length();i++){
            freq[chars.charAt(i)-'a']++;
        }

        int res =0;

        for(int i=0;i<words.length;i++){
            String k = words[i];

            int[] temp = freq.clone();
            boolean valid = true;

            for(char ch : k.toCharArray()){
                 if(temp[ch-'a']==0){
                    valid = false;
                    continue;
                 }

                 temp[ch-'a']--;
            }

            if(valid==true){
                res=res+k.length();
            }
        }

        return res;
    }


}