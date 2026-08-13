/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> ls=new ArrayList<>();
    
    void solve(TreeNode root){
        if(root==null){
            return;
        }
        
        solve(root.left);
        ls.add(root.val);
        solve(root.right);

    }
    TreeNode solve2( int l, int r){
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode t=new TreeNode(ls.get(mid));
        t.left=solve2(l,mid-1);
        t.right=solve2(mid+1,r);
        return t;

        
        
    }
    public TreeNode balanceBST(TreeNode root) {
        solve(root);
        TreeNode t=solve2(0,ls.size()-1);
        return t;
    }
}