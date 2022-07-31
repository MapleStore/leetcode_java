package darren.gong.leetcode;

public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }
}
