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

    int prev = Integer.MIN_VALUE;
    int ans = Integer.MAX_VALUE;

    public void MinDist(TreeNode root) {

        if (root == null) {
            return;
        }

        MinDist(root.left);

        if (prev != Integer.MIN_VALUE) {
            ans = Math.min(ans, root.val - prev);
        }

        prev = root.val;

        MinDist(root.right);
    }

    public int minDiffInBST(TreeNode root) {

        prev = Integer.MIN_VALUE;
        ans = Integer.MAX_VALUE;

        MinDist(root);

        return ans;
    }
}