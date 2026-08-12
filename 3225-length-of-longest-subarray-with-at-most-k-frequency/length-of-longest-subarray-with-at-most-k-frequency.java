class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int ans=-1;
        HashMap<Integer,Integer> mp=new HashMap<>();
        while(r<n){
            if(mp.getOrDefault(nums[r],0)==k){
                while(nums[l]!=nums[r]){
                    mp.put(nums[l],mp.get(nums[l])-1);
                    l++;
                }
                l++;

                r++;
            }else{
                mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
                r++;
            }
            ans=Math.max(ans,r-l);
        }
        return ans;
        
    }
}