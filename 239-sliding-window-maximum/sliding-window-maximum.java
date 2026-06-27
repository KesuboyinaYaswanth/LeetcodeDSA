class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int in=0;
        int[] arr=new int[n-k+1];
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && q.peekFirst()<i-k+1){
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.removeLast();
                
            }
            q.offer(i);
            if(i>=k-1){
                arr[in++]=nums[q.peekFirst()];
            }

        }
        
        return arr;
    }
}