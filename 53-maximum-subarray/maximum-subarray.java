class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int tsum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            tsum=Math.max(sum,tsum);
            if(sum<0){
                sum=0;
            }
            
        }
        return tsum;
    }
}