package MyTree;
import java.util.*;


public class Node{
	Node left, right;
	int data;
	Node(int data){
		this.data = data;
		left = right = null;
	}
}

public class Deletion {

	Node root;
	public static void main(String[] args) {
		Deletion tree = new Deletion();
		tree.root = new Node(1);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(2);
       
        System.out.print( "Inorder traversal before Deletion:"); 
        inorder(tree.root); 
    
        int key = 4; 
        deleteReq(tree.root, key); 
    
        System.out.print("\nInorder traversal after Deletion:"); 
        inorder(tree.root);
	}

	public static void inorder(Node root) {
		if(root == null)return;
		inorder(root.left);
		System.out.print(" "+root.data);
		inorder(root.right);
	}
	//delete the req node and in that position replace with deepest node value
	public static void deleteReq(Node root, int key) {
		if(root == null)return;
		Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    Node key_node = null, temp = null;
	    while(!q.isEmpty()) {
	    	 temp = q.poll();
	    	if(temp.data == key) {
            key_node = temp;
	    	}
	    	if(temp.left != null) {
	    		q.add(temp.left);
	    	}
	    	if(temp.right != null) {
	    		q.add(temp.right);
	    	}
	    }
	    int x = temp.data;
	    deleteDeepest(root, temp);
	    key_node.data = x;
	}
	//Delete deepest node and repalce it position from that to req delete position
	public static void deleteDeepest(Node root, Node deepestNode) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.right != null) {
				if(temp.right == deepestNode) {
					temp.right = null;
					deepestNode = null;
					return;
				}else {
					q.add(deepestNode);
				}
			}
			if(temp.left != null) {
				if(temp.left == deepestNode) {
					temp.left = null;
					deepestNode = null;
					return;
				}else {
					q.add(temp.left);
				}
			}
		}
	}
}
