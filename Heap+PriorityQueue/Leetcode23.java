/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0 )
            return null;
        int len = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            new Comparator<ListNode>(){
                public int compare(ListNode a, ListNode b){
                    if(a.val < b.val)
                        return -1;
                    else if(a.val >b.val)
                        return 1;
                    else
                        return 0;
                }
            }
        );
        for(int i = 0; i<lists.length; i++) {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while(pq.size() != 0) {
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            temp = temp.next;
            if(temp != null){
                pq.offer(temp);
            }
        }
        return dummyHead.next;
            
        
        // if(lists==null||lists.length==0) return null;
        // int len=lists.length;
        // int steps=1;
        // while(steps<len)
        // {
        //     for(int i=0;i+steps<len;i=i+steps*2)
        //         lists[i]=merge2Lists(lists[i],lists[i+steps]);
        //     steps=steps*2;
        // }
        // return lists[0];
    }
    // public ListNode merge2Lists(ListNode l1,ListNode l2)
    // {
    //     ListNode head=new ListNode(0);
    //     ListNode index=head;
    //     while(l1!=null&&l2!=null)
    //     {
    //         if(l1.val<=l2.val)
    //         {
    //             index.next=l1;
    //             l1=l1.next;
    //         }
    //         else
    //         {
    //             index.next=l2;
    //             l2=l2.next;
    //         }
    //         index=index.next;
    //     }
    //     if(l1==null)
    //         index.next=l2;
    //     else if(l2==null)
    //         index.next=l1;
    //     return head.next;
    // }
}