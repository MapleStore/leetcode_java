package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode current = head;
        int index = 0;
        while (current != null) {
            arrayList.add(index++, current);
            current = current.next;
        }
        int start = 0;
        int end = arrayList.size()-1;
        current = head;
        ListNode pre = new ListNode(-1);
        pre.next = current;
        while (start <= end) {
            current.next = arrayList.get(end--);
            current = current.next;
            pre = pre.next;
            if (start <= end) {
                current.next = arrayList.get(++start);
                current = current.next;
                pre = pre.next;
            }
        }
        pre.next = null;
        return;
    }
}
