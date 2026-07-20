class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        k=k%(m*n);
        int cnt=0;
        int a=0;
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ls.add(grid[i][j]);
            }
        }
        for(int i=0;i<k;i++){
            ls.add(0, ls.get(m*n -1));
            ls.remove(m*n);
        }
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<m;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                temp.add(ls.get(cnt++));
            }
            ans.add(temp);
        }
        return ans;
    }
}