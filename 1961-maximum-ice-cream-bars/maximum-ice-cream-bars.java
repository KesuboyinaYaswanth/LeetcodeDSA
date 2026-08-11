class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        Arrays.sort(costs);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(coins<costs[i]){
                return cnt;
            }
            cnt++;
            coins-=costs[i];
        }
        return cnt;
    }
}