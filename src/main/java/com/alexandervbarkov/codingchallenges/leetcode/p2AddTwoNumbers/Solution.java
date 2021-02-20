package com.alexandervbarkov.codingchallenges.leetcode.p2AddTwoNumbers;

import com.alexandervbarkov.codingchallenges.common.ListNode;

public class Solution {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        new Solution().addTwoNumbers(l1, l2).print();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (isDone(l1, l2, carry)) return null;
        int v1 = getVal(l1);
        int v2 = getVal(l2);
        int val = v1 + v2 + carry;
        if (val > 9) {
            val -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        ListNode listNode = new ListNode(val);
        l1 = getListNode(l1);
        l2 = getListNode(l2);
        listNode.next = addTwoNumbers(l1, l2, carry);
        return listNode;
    }

    private ListNode getListNode(ListNode listNode) {
        return listNode == null ? null : listNode.next;
    }

    private boolean isDone(ListNode l1, ListNode l2, int carry) {
        return l1 == null && l2 == null && carry == 0;
    }

    private int getVal(ListNode listNode) {
        return listNode == null ? 0 : listNode.val;
    }
}
