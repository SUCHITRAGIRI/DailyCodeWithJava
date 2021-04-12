/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
//GFG problem:
https://practice.geeksforgeeks.org/problems/sum-tree/1/?track=dsa-workshop-1-trees&batchId=308#
*/
class Solution {
    boolean isSumTree(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        int l = sumOfNode(root.left);
        int r = sumOfNode(root.right);

        if (l + r == root.data && isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }
        return false;
    }

    public int sumOfNode(Node root) {
        if (root == null)
            return 0;
        return root.data + sumOfNode(root.left) + sumOfNode(root.right);
    }

}
