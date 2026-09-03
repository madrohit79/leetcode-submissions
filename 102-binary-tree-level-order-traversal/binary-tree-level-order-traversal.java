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

    List<List<Integer>> blist = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return blist;
        }
        levelOrder(root,0);
        return blist;
    }
    public void levelOrder(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(blist.size()==level){
            blist.add(new ArrayList<>());
        }
        blist.get(level).add(root.val);
        levelOrder(root.left,level+1);
        levelOrder(root.right,level+1);
    }
}