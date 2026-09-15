/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *         val = x;
 *     }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        while (root != null) {

            // Both are on LEFT
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both are on RIGHT
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Split point → LCA
            else {
                return root;
            }
        }

        return null;
    }
}