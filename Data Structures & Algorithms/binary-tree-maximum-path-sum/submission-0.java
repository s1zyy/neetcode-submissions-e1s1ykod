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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int sum = gain(root);
        return maxSum;
    }






    public int gain(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftPath = Math.max(0, gain(root.left));
        int rightPath = Math.max(0, gain(root.right));

        if((leftPath + rightPath + root.val) > maxSum) {
            maxSum = leftPath + rightPath + root.val;
        }

        return root.val + Math.max(leftPath, rightPath);
    }
}
