class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> test=new HashMap<>();
            int maxel=0;
            int maxc=-1;
            
            for(int j=i;j<n;j++){
                test.put(nums[j],test.getOrDefault(nums[j],0)+1);
                if((test.get(nums[j])>maxc) || (test.get(nums[j])==maxc && nums[j]==target)){
                    maxc=test.get(nums[j]);
                    maxel=nums[j];
                }
                if(maxel== target && maxc>(j-i+1)/2){
                    ans++;
                }else{
                    
                }
                
            }
        }
        return ans;
    }
}