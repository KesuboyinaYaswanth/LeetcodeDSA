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
    public static boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        return hps(root,targetSum);
    }
    public static boolean hps(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                return true;
            }else{
                return false;
            }
            
        }
        return hps(root.left,targetSum-root.val)|| hps(root.right,targetSum-root.val);
    }
}