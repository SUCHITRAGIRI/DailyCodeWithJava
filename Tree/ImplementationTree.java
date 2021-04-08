package MyTree;
//Binary Tree implementation 
class Node{
	int data;
	Node left;
	Node right;
	public Node(int val) {
		data = val;
		left = right = null;
		
	}
}

public class ImplementationTree {
	Node root;
	ImplementationTree(int key) {
		root = new Node(key);
	}
	ImplementationTree() {
		root = null;
	}
	
	//traverse
	//### Preorder
	public  void PreOrdertraverse(Node root) {
		if(root == null)return;
		System.out.print(root.data + " - ");
		PreOrdertraverse(root.left);
		PreOrdertraverse(root.right);
	}
	//### Inorder traversal
	public  void InOrdertraverse(Node root) {
		if(root == null)return;
		InOrdertraverse(root.left);
		System.out.print(root.data + " - ");
		InOrdertraverse(root.right);
	}

	//###Post order traversal
	public void PostOrdertraversal(Node root) {
		if(root == null)return;
		PostOrdertraversal(root.left);
		PostOrdertraversal(root.right);
		System.out.print(root.data + " - ");
	}
	
	public static void main(String[] args) {
    
    ImplementationTree tree = new ImplementationTree();
    //create a root
    tree.root = new Node(1);
    //then create subtree
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    System.out.println("Binary Tree : \n");
    System.out.println("PreOrder ");
    tree.PreOrdertraverse(tree.root);
    System.out.println("\n Inorder :");
    tree.InOrdertraverse(tree.root);
    System.out.println("\n PostOrder");
    tree.PostOrdertraversal(tree.root);
	}

}
