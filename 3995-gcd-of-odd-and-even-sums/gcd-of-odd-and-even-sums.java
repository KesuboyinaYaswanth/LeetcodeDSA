class Solution {
    public static int gcd(int a,int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int a=(n*(2+2*(n-1)))/2;
        int b=(n*(4+2*(n-1)))/2;
        return gcd(a,b);
    }
}