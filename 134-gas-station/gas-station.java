class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int[] gas2=new int[2*n];
        int start=0;
        int curr_sum=0;
        int tot_sum=0;
        for(int i=0;i<n;i++){
            tot_sum+=gas[i]-cost[i];
            curr_sum+=gas[i]-cost[i];
            if(curr_sum<0){
                curr_sum=0;
                start=(i+1)%n;
            }
        }
        if(tot_sum<0){
            return -1;
        }else{
            return start;
        }
    }
}