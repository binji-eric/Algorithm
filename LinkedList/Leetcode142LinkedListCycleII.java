public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if(fast == slow) {
            fast = head;
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    return null;
}