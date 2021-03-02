package LinkedList;

public class Leetcode92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        } 
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        int distance = right - left;
        ListNode fast = dummyHead, slow = dummyHead, prev = dummyHead;
        // let the fast point go first
        while(fast != null && distance > 0) {
            fast = fast.next;
            distance--;
        }
        // dummyHead -> head->....-> prev -> slow->....fast -> next ...
         // dummyHead -> head->....-> prev -> fast->....slow -> next ...
        while(left > 0) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            left--;
        }
        ListNode next = fast.next;
        fast.next = null;
        prev.next = reverseList(slow, next);
        return dummyHead.next;
    }
    
    private ListNode reverseList(ListNode head, ListNode followNode) {
        ListNode cur = head, prev = followNode;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
