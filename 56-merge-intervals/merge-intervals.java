class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> ls=new ArrayList<>();
        
        int start=intervals[0][0],end=intervals[0][1];
        
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=end ){
                end=Math.max(end, intervals[i][1]);
            }else{
                ls.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ls.add(new int[]{start,end});
        int[][] ans=new int[ls.size()][2];
        for(int i=0;i<ls.size();i++){
            ans[i]=ls.get(i);
        }
        return ans;

    }
}