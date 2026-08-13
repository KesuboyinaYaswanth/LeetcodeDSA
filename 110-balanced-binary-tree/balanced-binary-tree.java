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
    boolean flag=true;
    public int solve(TreeNode ro){
        if(ro==null){
            return 0;
        }
        int l=solve(ro.left);
        int r=solve(ro.right);
        if(Math.abs(l-r)>=2){
            flag=false;
            return 0;
        }
        return 1+Math.max(l,r);

    }
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return flag;
    }
}