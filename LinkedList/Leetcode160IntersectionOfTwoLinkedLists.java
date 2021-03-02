package LinkedList;

public class Leetcode160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int countA = 0, countB = 0;
        ListNode curA = headA, curB = headB;
        while(curA != null) {
            countA++;
            curA = curA.next;
        }
        while(curB != null) {
            countB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // make curA and curB at the same race
        if(countA > countB) {
            int count = countA - countB;
            while(count > 0) {
                curA = curA.next;
                count--;
            }
        } else {
            int count = countB - countA;
            while(count > 0) {
                curB = curB.next;
                count--;
            }
        }
        // iterate the list to find the intersection
        while(curA != null && curB != null) {
            if(curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;  
    }
}
