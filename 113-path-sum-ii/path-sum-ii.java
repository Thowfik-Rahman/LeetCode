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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findPaths(root, targetSum, path, result);

        return result;
    }

    private void findPaths(
            TreeNode root,
            int targetSum,
            List<Integer> path,
            List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        // ROOT
        path.add(root.val);
        targetSum -= root.val;

        // LEAF
        if (root.left == null && root.right == null) {

            if (targetSum == 0) {
                result.add(new ArrayList<>(path));
            }

            path.remove(path.size() - 1);
            return;
        }

        // LEFT
        findPaths(root.left, targetSum, path, result);

        // RIGHT
        findPaths(root.right, targetSum, path, result);

        // BACKTRACK
        path.remove(path.size() - 1);
    }
}