var deleteDuplicates = function(head) {
    const dummyHead = new ListNode(-1);
    dummyHead.next = head;
    let pre = dummyHead, cur = dummyHead.next;
   while(cur != null && cur.next != null) {
            // 如果当前节点与之后节点不同，pre和cur同时向后移动
            if(cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            // 如果当前节点与之后节点相同，需要去重直到新值节点，连接pre与cur，但是pre不更新
            } else {
                const value = cur.val;
                while(cur != null && cur.val == value) {
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }
    return dummyHead.next;
};