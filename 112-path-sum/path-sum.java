class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return solve(root, targetSum, 0);
    }

    public boolean solve(TreeNode root, int target, int sum) {

        if (root == null) return false;

        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == target;
        }

        boolean left = solve(root.left, target, sum);
        boolean right = solve(root.right, target, sum);

        return left || right;
    }
}