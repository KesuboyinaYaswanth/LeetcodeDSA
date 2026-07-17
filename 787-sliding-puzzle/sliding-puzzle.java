class Solution {
    public static String finalb="123450";
    public static int[][] moves={
        {1,3},
        {0,2,4},
        {1,5},
        {0,4},
        {3,1,5},
        {2,4}
    };
    public static String swap(String ssb, int i, int j){
        StringBuilder sb=new StringBuilder(ssb);
        sb.setCharAt(i, ssb.charAt(j));
        sb.setCharAt(j, ssb.charAt(i));
        return sb.toString();
    }
    public static void solve(String bl,int in, int count, HashMap<String,Integer> mp){
        if(mp.containsKey(bl) && mp.get(bl)<=count){
            return;
        }
        mp.put(bl,count);
        for(int a:moves[in]){
            String nbl=swap(bl,in,a);
            solve(nbl,a,count+1,mp);
        }

    }
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                sb.append(board[i][j]);
            }
        }
        HashMap<String,Integer> mp=new HashMap<>();
        solve(sb.toString(), sb.indexOf("0"),0,mp);
        return mp.getOrDefault(finalb,-1);
        
    }
}