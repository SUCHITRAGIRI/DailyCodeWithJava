package MyTree;
import java.util.*;
class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left = right = null;
	}
}

public class Insersation {
    Node root;
    Insersation(){
    	root = null;
    }
	public static void main(String[] args) {
		Insersation tree = new Insersation();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(5);
		tree.root.right.right = new Node(6);
//		    1 
//	      /   \	
//       2	   3
//		/       \
//		5        6
		System.out.println("Inoder Traversal before insertion");
		inOrder(tree.root); //5, 2, 1, 3, 6
		int key = 12;
		insert(tree.root, key);
		System.out.println("\nInoder Traversal After insertion");
		inOrder(tree.root); // 5 2 12 1 3 6
	}
   //Inorder Traversal : 
	public static void inOrder(Node root) {
		if(root == null)return;
		inOrder(root.left);
		System.out.print(" " + root.data);
		inOrder(root.right);
	}
	
	public static void insert(Node root, int key) {
		Queue<Node> q = new LinkedList<>();
		if(root == null) {
			root = new Node(key);
		}
		q.offer(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.left == null) {
				node.left = new Node(key);
				break;
			}else {
				q.add(node.left);
			}
			if(node.right == null) {
				node.right = new Node(key);
				break;
			}else {
				q.add(node.right);
			}
		}
	}
	
}
