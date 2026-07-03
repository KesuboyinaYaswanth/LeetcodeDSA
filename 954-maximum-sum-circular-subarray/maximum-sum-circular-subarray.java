class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int maxmid=Integer.MIN_VALUE;
        int currsum=0;

        for(int i=0;i<n;i++){
            currsum=Math.max(currsum+nums[i],nums[i]);
            maxmid=Math.max(maxmid,currsum);
        }
        int sufsum=0;
        int[] rpref=new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                rpref[i]=nums[i];
                sufsum=nums[i];
            }else{
                sufsum+=nums[i];
                rpref[i]=Math.max(rpref[i+1],sufsum);
            }
        }
        int[] leftsum=new int[n];
        sufsum=0;
        int corsum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i==0){
                leftsum[i]=nums[i];
                sufsum+=nums[i];
                continue;
            }
            sufsum+=nums[i];
            leftsum[i]=Math.max(leftsum[i-1],sufsum);
            if(i==n-1){
                corsum=Math.max(corsum,leftsum[i]);
                continue;
            }
            corsum=Math.max(corsum,rpref[i+1]+leftsum[i]);
        }
        return Math.max(maxmid,corsum);
    }
}