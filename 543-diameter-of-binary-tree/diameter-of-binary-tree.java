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
    int d=0;
    public int diameterOfBinaryTree(TreeNode root){
        height(root);
        return d;
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lefth=height(root.left);
        int righth=height(root.right);
        d=Math.max(d,lefth+righth);
        return 1+Math.max(lefth,righth);
    }
}