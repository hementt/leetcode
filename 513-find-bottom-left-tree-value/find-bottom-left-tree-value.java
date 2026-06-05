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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;

            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                
                if(!flag){
                    res = node.val;
                    flag = true;
                }

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null) q.add(node.right);
            }
        }
        return res;

    }
}