var deleteDuplicates = function(head) {
    const dummyHead = new ListNode(-1);
    dummyHead.next = head;
    let cur = dummyHead.next;
    while(cur) {
        let next = cur.next;
        while(next && next.val == cur.val) {
            next = next.next;
        }
        cur.next = next;
        cur = next;
    }
    return dummyHead.next;
};