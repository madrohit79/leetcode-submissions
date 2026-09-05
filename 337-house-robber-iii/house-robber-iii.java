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
class Solution { // yt:nikhil lohia;
    public int rob(TreeNode root) {
        int[] options = travel(root); 
        return Math.max(options[0],options[1]);
    }
    public int[] travel(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] leftnodechoices = travel(root.left);
        int[] rightnodechoices = travel(root.right);
        int[] options = new int[2];
        options[0] = root.val + leftnodechoices[1] + rightnodechoices[1];
        options[1] = Math.max(leftnodechoices[0],leftnodechoices[1]) + Math.max(rightnodechoices[0],rightnodechoices[1]);

        return options;
    }
}