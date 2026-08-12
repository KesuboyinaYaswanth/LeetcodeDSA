class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int c=0;
        int i=0;
        for(int j=1;j<n;j++){
            if(intervals[j][0]<intervals[i][1]){
                c++;
            }else{
                i=j;
            }
        }
        return c;
        
    }
}