class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<r){
            if(nums[l]!=nums[l+1] && nums[r]!=nums[r-1]){
                break;
            }
            if(nums[l]==nums[l+1]){
                l++;
            }
            if(nums[r]==nums[r-1]){
                r--;
            }
        }
        if(l==r){
            return nums[l];
        }else{
            int mid=l+(r-l)/2;
            while(l<r){
                mid=l+(r-l)/2;
                if(nums[mid]<=nums[r]){
                    r=mid;
                }else if(nums[mid]>nums[r]){
                    l=mid+1;
                }
            }
            return nums[l];
        }
    }
}