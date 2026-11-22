class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;

        ArrayList<Integer> arr = new ArrayList<>();

        while(left<=right && top<=bottom){


            //left to right
            for(int i=left;i<=right;i++){
              arr.add(matrix[top][i]);
            }
            top++;

            //top to bottom
            for(int i=top;i<=bottom;i++){
                arr.add(matrix[i][right]);
            }

            right--;

            //right to left
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                arr.add(matrix[bottom][i]);
            }
            bottom--;
            }
            //bottom to top
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    arr.add(matrix[i][left]);
                }
                left++;
            }


        }

        return arr;
    }
}