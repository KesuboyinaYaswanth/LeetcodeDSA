class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        HashSet<Integer> st=new HashSet<>();
        long sum=0;
        long ans=0;
        while(r<n){
            while(st.contains(nums[r])){
                sum-=nums[l];
                st.remove(nums[l]);
                l++;
            }
            sum+=nums[r];
            st.add(nums[r]);
            if(r-l+1==k){
                ans=Math.max(ans,sum);
                sum-=nums[l];
                
                st.remove(nums[l]);
                l++;
            }
            

            r++;
        }
        return ans;
    }
}