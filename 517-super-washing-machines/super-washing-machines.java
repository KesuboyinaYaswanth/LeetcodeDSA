class Solution {
    public int findMinMoves(int[] machines) {
        int n=machines.length;
        int tsum=0;
        for(int a: machines){
            tsum+=a;
        }
        if(tsum%n!=0){
            return -1;
        }
        int k=tsum/n;
        int maxi=0;
        int dif=0;
        int c_dif=0;
        for(int a: machines){
            dif=a-k;
            c_dif=c_dif+dif;
            maxi=Math.max(dif,Math.max(maxi,Math.abs(c_dif)));
        }
        return maxi;
    }
}