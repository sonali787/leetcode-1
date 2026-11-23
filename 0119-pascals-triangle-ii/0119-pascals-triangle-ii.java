class Solution {
    public List<Integer> getRow(int r) {
         List<List<Integer>> l = new ArrayList<>();

        for(int i=0;i<=r;i++){
            l.add(new ArrayList<>());
        }
       
         for(int i =0;i<=r;i++){
            for(int j=0;j<=i;j++){
                if(i==0||j==i||j==0){
                    l.get(i).add(1);
                }else{
                    int ele = l.get(i-1).get(j-1) + l.get(i-1).get(j);
                    l.get(i).add(ele);
                }
            }
         }
        List<Integer> res= l.get(r);
        return res;
    }
}