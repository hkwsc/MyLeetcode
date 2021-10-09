package leetcode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,null);
        System.out.println(removeNthFromEnd(head,1));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1,p2,q1,q2;
        p1=l1;
        q1=l2;
        p2=l1.next;
        q2=l2.next;
        ListNode r=new ListNode();
        ListNode head=r;
        while (p1!=null&&q1!=null)
        {
            if(p1.val>q1.val)
            {
                r.next=q1;
                q1=q2;
                q2=q2.next;
                r=r.next;
            }
            else
            {
                r.next=p1;
                p1=p2;
                p2=p2.next;
                r=r.next;
            }
            if(p1==null)
            {
                if(q1!=null)
                    r.next=q1;
            }
            else
            {
                if(p1!=null)
                    r.next=p1;
            }
        }
        return head.next;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head,q=head;
        for(int i=0;i<n;i++)
            q=q.next;
        if(q==null)
        {
            head=head.next;
            return head;
        }
        while (q.next!=null)
        {
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        return head;
    }
}