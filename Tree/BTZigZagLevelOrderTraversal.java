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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //using ArrayList and BFS approach!
        //if root is null
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean zigzag = false; // left to right
        // True for right to left
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(zigzag){
                    level.add(0, node.val);
                }else{
                    level.add(node.val);
                }
                
                if(node.left != null)
                    q.add(node.left);
                
                if(node.right != null)
                    q.add(node.right);
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }
}
