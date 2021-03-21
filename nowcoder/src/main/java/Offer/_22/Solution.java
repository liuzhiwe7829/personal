package Offer._22;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, behind = head;
        int n = 0;
        while (head.next!=null){
            n++;
            head =head.next;
        }
        System.out.println(n);
        // 倒数 k  正数 length - k+1;
        int c=0;
        while (pre.next!=null){
            if(c==(n-k+1)){
                return pre;
            }
            pre= pre.next;
            c++;

        }
        return pre;
    }
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        if(stack.isEmpty()){
            return  null;
        }
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }

}
 class ListNode {
     int val;
      ListNode next;

      ListNode(int x) { val = x; }
  }