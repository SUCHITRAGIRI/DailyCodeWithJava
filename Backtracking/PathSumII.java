//https://leetcode.com/problems/path-sum-ii/submissions/




class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        dfs(root, sum, res, path);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList(path));
        dfs(root.left, sum - root.val, res, path);
        dfs(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}
