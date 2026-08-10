class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefpr=new int[n];
        int[] sufpr=new int[n];
        for(int i=0;i<n;i++){
            int j=n-1-i;
            if(i==0){
                prefpr[i]=1;
                sufpr[j]=1;
            }else{
                prefpr[i]=prefpr[i-1]*nums[i-1];
                sufpr[j]=sufpr[j+1]*nums[j+1];
            }
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=sufpr[i]*prefpr[i];
        }
        return ans;
    }
}