//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1/?track=dsa-workshop-1-linkedlist&batchId=308#

class Solution
{
    public static Node reverse(Node node, int k)
    {
    //if(node == null || node.next == null)return node;
     
     Node prev  = null, next = null, curr = node;
     int temp = k;
     while(temp-->0 && curr != null){
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
     }
     if(next != null)
     node.next = reverse(next, k);
     return prev;
    }
}
