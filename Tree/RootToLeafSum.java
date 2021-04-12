//https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/0/?track=dsa-workshop-1-trees&batchId=308

/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    /* you are required to complete this function */

    boolean hasPathSum(Node root, int S) {
        if (root == null) {
            if (S == 0)
                return true;
            else
                return false;
        }

        return hasPathSum(root.left, S - root.data) || hasPathSum(root.right, S - root.data);
    }

}
