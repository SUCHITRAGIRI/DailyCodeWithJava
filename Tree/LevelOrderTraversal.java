package MyTree;
import java.util.*;

class Node{
	int data;
	Node left, right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
//Implementation of Tree Level Order Traversal
class LevelOrderTraversal {

	Node root;
	public LevelOrderTraversal(){// constructor for initializing the root node
		root = null;
	}
	
	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();// Here data of node is not provide at run time
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = null;
		tree.root.right.left = new Node(6);

		System.out.println(levelOrderTraversal(tree.root));
	}
	
	public static List<Integer> levelOrderTraversal(Node root){// method of level order traversal and return in a list
		List<Integer> list = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		if(root == null)return list;
		q.offer(root);
		while(!q.isEmpty()) {
			Node nodeTemp = q.poll();
			list.add(nodeTemp.data);
			if(nodeTemp.left != null) {
				q.offer(nodeTemp.left);
			}
			if(nodeTemp.right != null) {
				q.add(nodeTemp.right);
			}
		}
		return list;
	}

}






