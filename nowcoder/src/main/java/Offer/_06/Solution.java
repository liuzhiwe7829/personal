package Offer._06;


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if(head==null){
            return  new int[0];
        }
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        int [] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            res[i++] = stack.pop().val;
        }
        return res;
    }
}