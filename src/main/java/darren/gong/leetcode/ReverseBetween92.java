package darren.gong.leetcode;

public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode preReverse = newHead;
        int index = 0;
        while (++index < m) {
            preReverse = preReverse.next;
        }
        ListNode current = preReverse.next;
        ListNode firstReverse = current;
        while (index++ <= n) {
            ListNode next = current.next;
            current.next = preReverse.next;
            preReverse.next = current;
            current = next;
        }
        firstReverse.next = current;
        return newHead.next;
    }
}
