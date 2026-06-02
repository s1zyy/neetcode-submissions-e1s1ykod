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
    boolean left = false;
    boolean right = false;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;


        if(p.val != q.val) {
            return false;
        }

        left = isSameTree(p.left,q.left);
        if(!left) return false;
        System.out.println(p.val + " "  + q.val);
        System.out.println(left);
        System.out.println("-------");
        right = isSameTree(p.right,q.right);
        if(!right) return false;
        System.out.println(right);
        return true;
        
    }
}
