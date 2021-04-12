//https://leetcode.com/problems/deepest-leaves-sum/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int sum = 0;
    private int maxLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        findDeepestLevelSum(root, 0);
        return sum;
    }

    private void findDeepestLevelSum(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxLevel) {
            sum = 0;
            maxLevel = level;
        }
        if (level == maxLevel) {
            sum += root.val;
        }
        findDeepestLevelSum(root.left, level + 1);
        findDeepestLevelSum(root.right, level + 1);
    }
}
