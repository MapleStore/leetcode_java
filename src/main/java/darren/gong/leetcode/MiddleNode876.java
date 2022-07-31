package darren.gong.leetcode;

public class MiddleNode876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (two.next != null && two.next.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one.next;
    }
}
