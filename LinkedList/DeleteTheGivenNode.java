//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1/?company[]=Amazon&company[]=Amazon&page=1&query=company[]Amazonpage1company[]Amazon#
//Here the problem is the we have given the refernece of the deleted node and we don't given the head refernce so, our task is to delete that perticular node.

//It seems really complex ..
//but solution is dumpp.. XD
//we just need to copy the value of next of deleted node in deleted node nd just delete the delete.next node.

class Solution
{
    void deleteNode(Node del)
    {
         Node curr = del.next; //take a refernce of next node
         del.data = curr.data; // copy the value of curr in give node
         del.next = curr.next;// just delete the next node
         
    }
}
