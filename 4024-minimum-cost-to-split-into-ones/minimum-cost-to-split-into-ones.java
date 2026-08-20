class Solution {
    
    
    
    public int minCost(int n) {
        int[] dp=new int[n+1];
        dp[1]=0;
        dp[0]=0;
        for(int i=2;i<n+1;i++){
            int miny=Integer.MAX_VALUE;
            for(int j=1;j<i;j++){
                miny=Math.min(miny, j*(i-j)+dp[j]+dp[i-j]);
            }
            dp[i] = miny;
        }
        return dp[n];
    }
}