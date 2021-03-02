public ListNode oddEvenList(ListNode head) {
    // if the size of list <= 2, return head
    if(head == null || head.next == null || head.next.next == null) {
        return head;
    }
    ListNode evenHead = head.next, odd = head, even  = evenHead, cur = head.next.next;
    
    int count = 3;
    even.next = null;
    while(cur != null) {
        ListNode next = cur.next;
        cur.next = null;
        // 奇数
        if(count % 2 == 1) {
            odd.next = cur;
            odd = cur;
        }
        // 偶数
        else {
            even.next = cur;
            even = cur;
        }
        cur = next;
        count++;
    }
    odd.next = evenHead;
    return head;
}