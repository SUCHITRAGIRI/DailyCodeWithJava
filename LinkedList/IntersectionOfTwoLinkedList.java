
//https://leetcode.com/problems/intersection-of-two-linked-lists/
//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1/?track=dsa-workshop-1-linkedlist&batchId=308

//My solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA, p2=headB;
        int len1=0, len2=0,diff=0;
        while(p1!=null){
            len1++;
            p1=p1.next;
        }
        while(p2!=null){
            len2++;
            p2=p2.next;
        }
        p1=headA;
        p2=headB;
        
        if(len1<len2){
            diff=len2-len1;
            while(diff>0){
                p2=p2.next;
                diff--;
            }
        }else{
            diff=len1-len2;
            while(diff>0){
                p1=p1.next;
                diff--;
            }
        }
        
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}

//Little bit improvement

//1, Get the length of the two lists.

//2, Align them to the same start point.

//3, Move them together until finding the intersection point, or the end null

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA), lenB = length(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}

//Clean code but processing time is bit more
class Solution{
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
}
