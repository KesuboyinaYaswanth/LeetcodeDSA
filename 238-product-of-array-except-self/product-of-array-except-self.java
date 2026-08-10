class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int pref=1;
        int suf=1;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){

            ans[i]=pref;
            pref*=nums[i];
            
        }
        
        for(int i=n-1;i>=0;i--){

            ans[i]*=suf;
            suf*=nums[i];
            
        }
        return ans;
    }
}