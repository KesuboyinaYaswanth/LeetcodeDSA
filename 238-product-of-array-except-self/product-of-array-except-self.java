class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefpr=new int[n];
        int[] sufpr=new int[n];
        for(int i=0;i<n;i++){
            int j=n-1-i;
            if(i==0){
                prefpr[i]=nums[i];
                sufpr[j]=nums[j];
            }else{
                prefpr[i]=prefpr[i-1]*nums[i];
                sufpr[j]=sufpr[j+1]*nums[j];
            }
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                ans[i]=sufpr[i+1];
            }else if(i==n-1){
                ans[i]=prefpr[i-1];
            }else{
                ans[i]=sufpr[i+1]*prefpr[i-1];
            }
        }
        return ans;
    }
}