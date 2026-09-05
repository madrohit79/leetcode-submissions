/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         if(root==null){
//             return "x,";
//         }
//         return root.val+","+serialize(root.left)+serialize(root.right);
//     }

//     // Decodes your encoded data to tree.
//     int i = 0;
//     public TreeNode deserialize(String data) {
//         int end = data.indexOf(',', i);
//         String value = data.substring(i, end);

//         i=end+1;
//         if(value.equals("x")){
//             return null;
//         }
//         TreeNode root = new TreeNode(Integer.parseInt(value));
//         root.left = deserialize(data);
//         root.right = deserialize(data);
//         return root;
//     }
// }                // this thing failed because i is a class-level variable. They want deserialize() to work without relying on state stored outside the function. ( leetcode problem )
public class Codec {
    public String serialize(TreeNode root) {
        if(root == null){
            return "x,";
        }
        return root.val+","+ serialize(root.left)+serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        int[] i = new int[1];
        return deserializeHelper(data, i);
    }
    public TreeNode deserializeHelper(String data, int[] i) {
        int end = data.indexOf(',', i[0]);
        String value = data.substring(i[0], end);
        i[0] = end + 1;
        if(value.equals("x")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializeHelper(data, i);
        root.right = deserializeHelper(data, i);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));