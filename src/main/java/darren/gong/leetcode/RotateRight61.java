package darren.gong.leetcode;

public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode current = head;
        ListNode last = null;
        int length = 0;
        while (current != null) {
            length++;
            last = current;
            current = current.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        int headNum = length - k;
        current = head;
        while (--headNum > 0) {
            current = current.next;
        }
        ListNode result = current.next;
        current.next = null;
        last.next = head;
        return result;
    }
}
