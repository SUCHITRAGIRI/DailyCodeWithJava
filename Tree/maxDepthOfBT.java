//https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int maxDepth = findDepth(root, 0);
        return maxDepth;
    }
    public int findDepth(TreeNode root, int level){
        if(root == null)return 0;
        int maxDepth = 0;
        maxDepth = Math.max(maxDepth, findDepth(root.left, level + 1));
        maxDepth = Math.max(maxDepth, findDepth(root.right, level + 1));
        maxDepth++;
        return maxDepth;
    }
}
