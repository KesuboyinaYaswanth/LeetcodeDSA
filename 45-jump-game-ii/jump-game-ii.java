class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int r=0;
        int l=0;
        while(r<n-1){
            int rr=0;
            for(int i=l;i<=r;i++){
                rr=Math.max(rr, i+nums[i]);
            }
            l=r+1;
            r=rr;
            jumps++;
        }
        return jumps;
    }
}