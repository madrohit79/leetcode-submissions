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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode newn = new TreeNode(val);
            root=newn;
            return root;
        }
        if(root.left==null&&root.val>val){
            TreeNode newn = new TreeNode(val);
            root.left=newn;
            return root;
        }
        if(root.right==null&&root.val<val){
            TreeNode newn = new TreeNode(val);
            root.right=newn;
            return root;
        }
        if(root.val<val){
            insertIntoBST(root.right,val);
        }
        if(root.val>val){
            insertIntoBST(root.left,val);
        }
        return root;

    }
}