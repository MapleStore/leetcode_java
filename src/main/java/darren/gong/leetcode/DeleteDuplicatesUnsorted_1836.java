package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicatesUnsorted_1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            count.put(temp.val, count.getOrDefault(temp.val, 0)+1);
        }
        ListNode temp = preHead;
        while (temp.next != null) {
            if (count.get(temp.next.val) > 1) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return preHead.next;
    }
}
