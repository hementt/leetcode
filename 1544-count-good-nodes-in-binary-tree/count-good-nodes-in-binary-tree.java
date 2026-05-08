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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + solve(root, Integer.MIN_VALUE);
    }
    public int solve(TreeNode root, int target){
        if(root == null) return 0;

        target = Math.max(target, root.val);

        int left =0;
        int right = 0;

        if(root.left != null && root.left.val >= target) left = 1 + solve(root.left, target);
        else left = solve(root.left, target);

        if(root.right != null && root.right.val >= target)  right = 1 + solve(root.right, target);
        else right = solve(root.right, target);

        return left + right;
    }
}