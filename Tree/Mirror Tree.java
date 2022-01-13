//https://practice.geeksforgeeks.org/problems/mirror-tree/1/?category[]=Tree&category[]=Tree&company[]=Amazon&company[]=Amazon&page=1&query=category[]Treecompany[]Amazonpage1company[]Amazoncategory[]Tree#




class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
    if(node == null)return;
    
    Node temp = node.left;  
    node.left = node.right;  // here we check update the pointers
    node.right = temp;       // means left will start pointing to right and vice versa
    
    mirror(node.left);   //same will goes for its left and right subtree itself!  (In simple the funda is that we just swape our left child with right child and same will followd by subtree utself
    mirror(node.right);
    
    }
    
}
