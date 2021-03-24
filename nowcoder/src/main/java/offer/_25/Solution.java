package offer._25;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l2 != null) {
            pre.next = l2;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        return head.next;


//        if(l1==null) {
//            return  l2;
//        }
//        if(l2 == null){
//            return  l1;
//        }
//        if(l1.val<l2.val){
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        }else {
//            l2.next =mergeTwoLists(l1,l2.next);
//            return l2;
//        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
