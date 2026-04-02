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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");

        buildString(root.left, sb);
        buildString(root.right,sb);

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
        
    }
    public TreeNode helper(Queue<String> nodes) {
        String val = nodes.poll();
        if(val.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper(nodes);
        node.right = helper(nodes);

        return node;

    }
}
