package com.junhqin.leetcode;

public class problem203 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode next = dummy.next;
        while (next!=null){
            if(next.val == val){
                pre.next = next.next;
                next = next.next;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }
        return dummy.next;
    }
}
