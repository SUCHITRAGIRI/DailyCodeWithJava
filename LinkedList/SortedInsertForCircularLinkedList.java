//https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1/?track=dsa-workshop-1-linkedlist&batchId=308#
//Really enjoyed with this problem:)

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class Solution
{
	//The problem statement is: we have given circular sorted linkedlist, and data for intering in its proper position so 
	//so that it remain in sorting order!
	public static Node sortedInsert(Node head,int data)   
         {
	    //condition 1: if data is less than head's data so in this case we have to insert data befor the head and make it as new head	
	    //condition 2: if the data is largest or in betw the node's data, in this case we just have to  maintain our pointer accordingly,with the help of two pointers prev and next.	
            if(head == null)return new Node(data);
            Node last = head;
            while(last.next != head){
                last = last.next;
            }
            if(head.data >= data){
                Node newNode = new Node(data);
                newNode.next = head;
                last.next = newNode;
                head = newNode;
            }
           else {
              Node temp = head.next;
              Node prev = head;
               while(temp.data < data && temp != head){
                   prev = temp;
                   temp = temp.next;
               }
               Node newNode = new Node(data);
               newNode.next = temp;
               prev.next = newNode;
           }
           return head;
         }
}
