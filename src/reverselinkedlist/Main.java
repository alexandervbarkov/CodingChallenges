package reverselinkedlist;

import common.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        head.print();
        System.out.println();
        new Main().reverseList(head).print();
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        while(head != null) {
            newHead = new ListNode(head.val);
            newHead.next = next;
            next = newHead;
            head = head.next;
        }
        return newHead;
    }
}
