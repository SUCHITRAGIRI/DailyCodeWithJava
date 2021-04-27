package MyTree;
import java.util.*;
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}
public class RightView {
    Node root;
	public static void main(String[] args) {
		RightView node = new RightView();
		node.root = new Node(1);
		node.root.left = new Node(2);
		node.root.right = new Node(3);
		node.root.left.left = new Node(4);
		node.root.left.right = new Node(5);
		System.out.println(node.rightView(node.root));
	}
	    //Function to return list containing elements of right view of binary tree.
	    ArrayList<Integer> rightView(Node node) {
	        ArrayList<Integer> res = new ArrayList<>();
	        Deque<Node> queue = new ArrayDeque<>();
	        if(node == null)return res;
	        queue.offer(node);
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i = 0; i < size; i++){
	                node = queue.poll();
	                if(i == size - 1)res.add(node.data);
	                if(node.left != null)queue.offer(node.left);
	                if(node.right != null)queue.offer(node.right);
	            }
	        }
	        return res;
	    }
	}


