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
    int indexofp=0;
    public TreeNode buildTree(int[] p, int[] i) {
        return build(p,i,0,i.length-1);
    }
    public TreeNode build(int[] p, int[] i, int l,int r){
        //base case
        if(l>r){
            return null;
        }
        TreeNode root=new TreeNode(p[indexofp]);
        indexofp++;
        int index=l;

        while(i[index]!=root.val){
            index++;
        }
        root.left=build(p,i,l,index-1);
        root.right=build(p,i,index+1,r);
        return root;
    }
}