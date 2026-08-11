class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int maxAr=-1,ar=0;
        while(l<r){
            ar = Math.min(height[l],height[r])*(r-l);
            maxAr=Math.max(maxAr, ar);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxAr;
    }
}