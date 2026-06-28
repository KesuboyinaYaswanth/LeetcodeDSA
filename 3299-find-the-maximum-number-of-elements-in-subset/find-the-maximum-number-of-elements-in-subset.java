class Solution {
    public int maximumLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(Integer key:mp.keySet()){
            if(key==1){
                continue;
            }
            int sz=0;
            while(true){
                if(mp.getOrDefault(key,0)>=2){
                    sz+=2;
                    key=key*key;
                }else if(mp.getOrDefault(key,0)==1){
                    sz++;
                    break;
                }else{
                    sz--;
                    break;
                }
            }
            ans=Math.max(ans,sz);
        }
        if(mp.getOrDefault(1,0)%2==0 && mp.getOrDefault(1,0)!=0){
            return Math.max(ans,mp.getOrDefault(1,0)-1);
        }
        return Math.max(ans,mp.getOrDefault(1,0));
    }
}