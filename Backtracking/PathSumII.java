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

//
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    helper(new ArrayList<Integer>(), root, sum);
    return result;
}

private void helper(List<Integer> list, TreeNode root, int sum) {
    if (root == null) return;
    list.add(root.val);
    sum -= root.val;
    if (root.left == null && root.right == null) {
        if (sum == 0) result.add(list);
        return;
    }
    helper(new ArrayList<Integer>(list), root.left, sum);
    helper(new ArrayList<Integer>(list), root.right, sum);
}
