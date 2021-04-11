public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    
   ListNode prev = head, slow = head, fast = head;
    // slow为第二段链表的起点
    while(fast!= null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    // 断掉两段链表之间的关系
    prev.next = null;
    return mergeSort(sortList(head), sortList(slow));
}

public ListNode mergeSort(ListNode left, ListNode right){
    ListNode dummyHead = new ListNode(-1), cur = dummyHead;
    while(left != null && right != null)
    {
        if(left.val<right.val)
        {
            cur.next= left;
            left=left.next;
        }
        else{
            cur.next= right;
            right=right.next;
        }
        cur = cur.next;
    }
    if(left == null){
       cur.next = right;
    }
    else {
       cur.next = left;
    }
    return dummyHead.next;
}
