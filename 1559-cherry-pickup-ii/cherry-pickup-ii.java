class Solution {
    public static int solve(int r1,int c1, int c2, int[][] grid, int m, int n, int[][][] dp){
        if(dp[r1][c1][c2]!=-1){
            return dp[r1][c1][c2];
        }
        if(r1==m-1){
            if(c1!=c2){
                return dp[r1][c1][c2]=grid[r1][c1]+grid[r1][c2];
            }else{
                return dp[r1][c1][c2]=grid[r1][c1];
            }
        }
        
        int samp1=0;
        int samp2=0;
        int samp3=0;
        int samp4=0;
        int samp5=0;
        int samp6=0;
        int samp7=0;
        int samp8=0;
        int samp9=0;
        if(c1-1>=0){
            samp1=solve(r1+1,c1-1,c2,grid,m,n,dp);
            if(c2-1>=0){
                samp2=solve(r1+1,c1-1,c2-1,grid,m,n,dp);
            }
            if(c2+1<n){
                samp3=solve(r1+1,c1-1,c2+1,grid,m,n,dp);
            }
        }
        if(c1+1<n){
            samp4=solve(r1+1,c1+1,c2,grid,m,n,dp);
            if(c2-1>=0){
                samp5=solve(r1+1,c1+1,c2-1,grid,m,n,dp);
            }
            if(c2+1<n){
                samp6=solve(r1+1,c1+1,c2+1,grid,m,n,dp);
            }
        }
        samp7=solve(r1+1,c1,c2,grid,m,n,dp);
        if(c2-1>=0){
            samp8=solve(r1+1,c1,c2-1,grid,m,n,dp);
        }
        if(c2+1<n){
            samp9=solve(r1+1,c1,c2+1,grid,m,n,dp);
        }
        int ans= Math.max(Math.max(Math.max(samp1,samp2),Math.max(samp3,samp4)), Math.max(Math.max(samp5,samp6),Math.max(samp7,samp8)));
        ans=Math.max(ans,samp9);
        if(c1!=c2){
            return dp[r1][c1][c2]=ans+grid[r1][c1]+grid[r1][c2];
        }else{
            return dp[r1][c1][c2]=ans+grid[r1][c1];
        }
    }
    public int cherryPickup(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,n-1,grid,m,n,dp);
    }
}