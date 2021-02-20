package com.alexandervbarkov.codingchallenges.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        System.out.print(val);
        if (next != null) {
            System.out.print(" -> ");
            next.print();
        }
    }
}
