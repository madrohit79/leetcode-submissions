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
    public TreeNode invertTree(TreeNode root) {
        TreeNode dummy = new TreeNode();
        if(root==null){
            return null;
        }
        dummy=root.right;//2 wala subtree
        root.right=root.left;
        root.left=dummy;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}