package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {
    public static void main(String[] args) {
        System.out.println(mergeKLists(new ListNode[]{}).val);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        List<ListNode> list=new ArrayList();
        ArrayList<ListNode> list1=new ArrayList()
        {{
            for(int i=0;i<lists.length;i++)
            {
                add(lists[i]);
            }
        }};
        mergeLists(list1);
        return list1.get(0);
    }
    static void mergeLists(ArrayList<ListNode> lists)
    {
        while (lists.size()!=1) {
            for (int i = 1; i < lists.size(); i+=2)
            {
                lists.set(i-1,RemoveNthFromEnd.mergeTwoLists(lists.get(i-1),lists.get(i)));
                lists.remove(i);
            }
        }
    }
}
