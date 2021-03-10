package LinkedList;

public class Leetcode206ReverseLinkedList {

    // 迭代版本
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归版本
    private ListNode tail;
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        helper(head);
        head.next = null;
        return tail;
    }
    
    public ListNode helper(ListNode head) {
        if(head.next == null) {
            tail = head;
            return head;
        }
        ListNode nextNode = helper(head.next);
        nextNode.next = head;
        return head;
    }
}
