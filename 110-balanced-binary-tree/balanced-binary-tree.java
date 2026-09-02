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
    Boolean ans = false;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return ans;
    }
    // public boolean balancing(TreeNode root){
    //     if(height(root.left)+height(root.right)<=1){
    //         return true;
    //     }
    //     return false;
    // }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lefth=height(root.left);
        int righth=height(root.right);
        return 1+Math.max(lefth,righth);
    }
}