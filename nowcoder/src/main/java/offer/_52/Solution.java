package offer._52;

import java.util.Stack;

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
//        Stack<ListNode> stackA = new Stack<>();
//        Stack<ListNode> stackB =new Stack<>();
//        while (headA!=null){
//            stackA.push(headA);
//            headA= headA.next;
//        }
//        while (headB!=null){
//            stackB.push(headB);
//            headB= headB.next;
//        }
//        ListNode node = null;
//        while (!stackA.empty()&& !stackB.empty()&& stackA.peek() == stackB.peek()){
//            node = stackA.peek();
//            stackA.pop();
//            stackB.pop();
//        }
//        return node;
        ListNode h1 =headA, h2 = headB;
        while (h1 !=h2){
            h1 = h1 ==null?headB:h1.next;
            h2 = h2 ==null?headA:h2.next;
        }
        return  h1;

    }
}
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }