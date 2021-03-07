package HJ48;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num =in.nextInt();
            Node head = new Node(in.nextInt());
            num--;
            while(num > 0){
                int cur = in.nextInt();
                int pre = in.nextInt();
                insert(head,pre,cur);
                num--;
            }
            int deleteVal = in.nextInt();
            //删除头节点
            if(head.val == deleteVal){
                head = head.next;
            }
            else{
                delete(head,deleteVal);
            }

            Node test = head;
            //打印输出
            while(test != null){
                System.out.print(test.val + " ");
                test = test.next;
            }
            //千万别忘了换行！！！！！！
            System.out.println();
        }
    }
    //插入Node
    public static void insert(Node head, int preVal, int newVal){
        Node newNode = new Node(newVal);
        Node cur = head;
        Node temp;
        while (cur!=null){
            if(cur.val==preVal){
                temp =cur.next;
                cur.next=newNode;
                newNode.next=temp;
                return;
            }
            cur=cur.next;
        }
    }

    //删除Node
    public static void delete(Node head, int delete){
        Node cur = head;
        while (cur.next!=null){
            if(cur.next.val==delete){
                cur.next=cur.next.next;
                return;
            }
            cur=cur.next;
        }
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}