package leetcode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = p1.next;
        ListNode r=new ListNode();
        head=r;
        while (p2!=null)
        {
            r.next=p2;
            p1.next=p2.next;
            p2.next=p1;
            r=p1;
            p1=r.next;
            if(p1!=null)
            p2=p1.next;
            else
              p2=null;
        }
        return head.next;
    }
}
