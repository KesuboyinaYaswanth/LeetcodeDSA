class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        int l=0;
        int r=n-1;
        int cnt=0;
        Arrays.sort(people);
        while(l<=r){
            if(people[l]+people[r]<=limit){
                cnt++;
                l++;
                r--;
            }else{
                cnt++;
                r--;
            }
        }
        return cnt;
    }
}