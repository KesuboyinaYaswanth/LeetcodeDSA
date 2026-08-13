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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return true;
        }
        TreeNode past=null;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                TreeNode temp=q.poll();
                if(temp!=null && temp!=root && past==null){
                    return false;
                }
                if(temp!=null){
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
                past=temp;
                n--;
            }
        }
        return true;
    }
}