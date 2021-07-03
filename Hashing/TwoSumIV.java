//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
   
    public boolean findTarget(TreeNode root, int k) {
      ArrayList<Integer> store = new ArrayList<>();
        storeInorder(root, store);  
        
        int i = 0, j = store.size() - 1;
        
        while(i < j){
            if(store.get(i) + store.get(j) == k)return true;
            else if(store.get(i) + store.get(j) < k)i++;
            else if(store.get(i) + store.get(j) > k)j--;
        }
        return false;
    }
    
    public void storeInorder(TreeNode root, ArrayList<Integer> store){
    
        if(root == null)return;
              
        storeInorder(root.left, store);
        store.add(root.val);
        storeInorder(root.right, store); 
         
    }
}
