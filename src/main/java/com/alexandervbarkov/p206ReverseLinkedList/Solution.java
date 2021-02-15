package com.alexandervbarkov.p206ReverseLinkedList;

import com.alexandervbarkov.common.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        head.print();
        System.out.println();
        new Solution().reverseList(head).print();
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
