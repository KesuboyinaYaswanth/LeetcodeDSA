class Solution {
    
    
    public int solve(int n, int[] dp) {
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n==1){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            ans=Math.min(ans, i*(n-i)+(solve(i,dp)+solve(n-i,dp)));
        }
        return dp[n]=ans;
    }
    public int minCost(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}