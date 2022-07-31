package darren.gong.leetcode;

public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }
        ListNode result = reverse(head, current);
        head.next = reverseKGroup(current, k);
        return result;
    }
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode preHead = new ListNode(-1);
        ListNode current = head;
        while (current != end) {
            ListNode next = current.next;
            current.next = preHead.next;
            preHead.next = current;
            current = next;
        }
        return preHead.next;
    }
}
