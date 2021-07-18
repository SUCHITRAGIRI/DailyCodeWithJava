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
	public static Node sortedInsert(Node head,int data)
         {
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
