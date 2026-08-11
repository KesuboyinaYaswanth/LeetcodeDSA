class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0;
        int r=0;
        int ans=0;
        HashSet<Character> st=new HashSet<>();
        while(r<n){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
            
            st.add(s.charAt(r));
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}