class Node{
    int freq;
    int first;
    int last;

    Node(int freq,int first,int last){
        this.freq=freq;
        this.first=first;
        this.last = last;
    }
}
class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Node> mp = new HashMap<>();
        int highest_freq=1;

        for(int i=0;i<n;i++){
            int ele = nums[i];
            if(!mp.containsKey(ele)){
                mp.put(ele,new Node(1,i,i));
            }else{
                Node k = mp.get(ele);
                mp.put(ele,new Node(k.freq + 1, k.first,i));
                highest_freq = Math.max(k.freq+1,highest_freq);
            }
        }


        int res = Integer.MAX_VALUE;

        for(Node node: mp.values()){
           int freq = node.freq;
           int first = node.first;
           int last = node.last;

           if(freq == highest_freq){
               res = Math.min(res,(last-first)+1);
           }
        }

        return res;

    }
}