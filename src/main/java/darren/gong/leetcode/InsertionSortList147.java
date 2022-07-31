package darren.gong.leetcode;

public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        ListNode current = head;
        ListNode preCurrent = preHead;
        while (current != null) {
            if (preCurrent.val <= current.val) {
                preCurrent = preCurrent.next;
                current = current.next;
            } else {
                preCurrent.next = current.next;
                ListNode preInsert = preHead;
                while (preInsert.next != null && preInsert.next.val <= current.val) {
                    preInsert = preInsert.next;
                }
                current.next = preInsert.next;
                preInsert.next = current;
                current = preCurrent.next;
            }
        }
        return preHead.next;
    }
}
