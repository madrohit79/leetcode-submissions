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
    List<Integer> slist = new ArrayList<>(); 
    // im trying to do bfs list of lists and return the right most element in each list which will be our right side view ultimately 
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return slist;
        }
        levelorder(root,0);
        return ans(blist);

    }
    public void levelorder(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(blist.size()==level){
            blist.add(new ArrayList<>());
        }
        blist.get(level).add(root.val);
        levelorder(root.left,level+1);
        levelorder(root.right,level+1);
    }
    public List<Integer> ans(List<List<Integer>> list){
        for(int i=0;i<list.size();i++){
            List<Integer> temp = list.get(i);
            slist.add(temp.get(temp.size()-1));
        }
        return slist;
    }
}