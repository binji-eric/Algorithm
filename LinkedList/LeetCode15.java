/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode pre = dummyHead;
        while(pre != null) {
            pre = reverse(pre, k);
        }
        return dummyHead.next;
    }
    
    private ListNode reverse(ListNode head, int k) {
        // head -> n1 -> n2 .. -> nk -> n(k+1)
        // head -> nk -> ...->n2 -> n1 -> n(k+1)
        ListNode cur = head;
        ListNode n1 = head.next;
        int count = 0;
        for(int i = 0; i< k; i++) {
            cur = cur.next;
            if(cur == null) {
                return null;
            }
        }
        ListNode nk = cur, nkplus = cur.next;
        
        // reverse
        ListNode pre = head;
        cur = head.next;
        while(cur != nkplus) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 当前链表
        // head <- n1 <- n2 .. <- nk  n(k+1)
        // 需要的结果
        // head -> nk ..->n2 ->n1 ->  n(k+1)
        head.next = nk;
        n1.next = nkplus;
        return n1;
    }
}