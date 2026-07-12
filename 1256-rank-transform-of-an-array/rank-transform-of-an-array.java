class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        HashSet<Integer> st=new HashSet<>();
        for(int a: arr){
            st.add(a);
        }
        ArrayList<Integer> ls=new ArrayList<>();
        for(Integer a: st){
            ls.add(a);
        }
        Collections.sort(ls);
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<ls.size();i++){
            mp.put(ls.get(i),i+1);
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=mp.get(arr[i]);
        }
        return ans;

    }
}