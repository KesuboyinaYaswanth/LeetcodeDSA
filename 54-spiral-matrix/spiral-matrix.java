class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        ArrayList<Integer> ls=new ArrayList<>();
        int top=0, bottom=m-1, left=0, right=n-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ls.add(matrix[top][i]);
            }
            top++;
            if(top>bottom){
                break;
            }
            for(int i=top;i<=bottom;i++){
                ls.add(matrix[i][right]);
            }
            right--;
            if(left>right){
                break;
            }
            for(int i=right;i>=left;i--){
                ls.add(matrix[bottom][i]);
            }
            
            bottom--;
            if(top>bottom){
                break;
            }
            for(int i=bottom;i>=top;i--){
                ls.add(matrix[i][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return ls;
    }
}