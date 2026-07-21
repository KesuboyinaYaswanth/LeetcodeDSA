class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int i=0;
        int prev=Integer.MIN_VALUE;
        int anso=0;
        int ans=0;
        int sa=0;
        while(i<n){
            while(i<n && s.charAt(i)=='1'){
                i++;
                anso++;
            }
            int cnt=0;
            while(i<n && s.charAt(i)=='0'){
                i++;
                cnt++;
            }
            if(cnt!=0 && prev!=Integer.MIN_VALUE){
                ans=Math.max(ans,cnt+prev);
            }
            
            
            prev=cnt;
            sa++;
        }
        return ans+anso;
    }
}