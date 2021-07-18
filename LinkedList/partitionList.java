//https://leetcode.com/problems/merge-two-sorted-lists/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode result1 = new ListNode(-1);
        ListNode result = result1;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                result.next = new ListNode(temp.val);
                result = result.next;
                }
            temp = temp.next;
            }
        temp = head;
        while(temp != null){
            if(temp.val >= x){
                result.next = new ListNode(temp.val);
                result = result.next;
                }
          temp = temp.next;
            }
        return result1.next;
        
    }
}
