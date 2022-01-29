//
//Time: O(N)
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        
        	int n = sc.nextInt();
        
            Node head = new Node(sc.nextInt());
            Node tail = head;
        
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
        
            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head); 
            t--;
        }
    } 
} 
   // } Driver Code Ends


//function Template for Java

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        //Node dummy = new Node(0);
       
       Node prev = null;
       Node next = null;
       Node curr = head;
       
       while(curr != null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       
        return prev;
    }
}


//recursive approach (In this approach we maitains the pointer in revese order while returing from base case)
        if(head==null|| head.next==null)return head;
       
        
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        
        return node;

//Another recursive approach! (Here 1st we maintain the order in reverse the pointer the go to ahead node!) and when reach the base case just return the newHead!
    public static Node reverseList1(Node head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private static Node reverseListInt(Node head, Node newHead) {
        if (head == null)
            return newHead;
        Node next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
