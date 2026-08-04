class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int x: nums){
            st.add(x);
        }
        int maxy=-1;
        int miny=1000;
        for(int a: nums){
            maxy=Math.max(maxy, a);
            miny=Math.min(miny,a);
        }
        List<Integer> ls=new ArrayList<>();
        for(int i=miny; i<=maxy;i++){
            if(!st.contains(i)){
                ls.add(i);
            }
        }
        return ls;
    }
}