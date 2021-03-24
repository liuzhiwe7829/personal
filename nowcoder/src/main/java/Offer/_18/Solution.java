package Offer._18;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        if(cur.val == val) {
            return  head.next;
        }
        while (cur.val!=val){
            pre = cur;
            cur=cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }