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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int counter = 0;
        while(curr != null || !stack.isEmpty()) {

            while(curr != null) {
            stack.push(curr);
            curr = curr.left;
            }

            curr = stack.pop();
            counter++;

            if(counter == k ) { return curr.val; }
            
            if(curr.right != null) {
                curr = curr.right;
            } else {
                curr = null;
            }
        }
        return -1;
        

        

    }
}
