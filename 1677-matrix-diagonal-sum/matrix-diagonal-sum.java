class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=mat[i][i]+mat[i][n-i-1];
            if(n%2!=0 && i==n/2){
                ans-=mat[i][i];
            }
        }
        return ans;
    }
}