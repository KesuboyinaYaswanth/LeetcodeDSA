class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        int ansi=0;
        
        for(int i=0;i<n;i++){
            String s2="";
            s2=s.substring(i,n)+s.substring(0,i);
            ansi=i;
            for(int j=0;j<n/2;j++){
                if(s2.charAt(j)==s2.charAt(n-j-1)){
                    continue;
                }else{
                    ansi+=Math.min(Math.abs(s2.charAt(j)-s2.charAt(n-j-1)), 26-Math.abs(s2.charAt(j)-s2.charAt(n-j-1)));
                }
            }
            ans=Math.min(ans,ansi);
        }
        return ans;
    }
}