class Solution {
    public static int solve(int i, int a, int n, int[][] costs, int[][] dp){
        if(dp[i][a]!=-1){
            return dp[i][a];
        }
        if(i==n){
            if(a!=n/2){
                return dp[i][a]=Integer.MAX_VALUE;
            }else{
                return dp[i][a]=0;
            }
        }
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(solve(i+1,a+1,n,costs,dp)!=Integer.MAX_VALUE){
            left=costs[i][0]+solve(i+1,a+1,n,costs,dp);
        }
        if(solve(i+1,a,n,costs,dp)!=Integer.MAX_VALUE){
            right=costs[i][1]+solve(i+1,a,n,costs,dp);
        }
        
        
        
        return dp[i][a]=Math.min(left,right);
    }
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(0,0,n,costs,dp);
    }
}