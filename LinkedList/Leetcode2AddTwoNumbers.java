public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode Head= new ListNode(0);
    ListNode p=l1, q=l2,current=Head;
   
   int x,y,sum,carry=0;
    while(p!=null||q!=null || carry > 0)
    {
        x=(p!=null)? p.val:0;
         y=(q!=null)? q.val:0;
   
         sum=x+y+carry;
        carry=sum/10;
        current.next=new ListNode(sum%10);
        current=current.next;
        p=(p!=null)?p.next:p;
        q=(q!=null)?q.next:q;
      
    }
   
    return Head.next;
    
}