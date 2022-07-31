package darren.gong.leetcode;

public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        ListNode next = one.next;
        one.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (left != null || right != null) {
            int leftValue = left == null ? Integer.MAX_VALUE : left.val;
            int rightValue = right == null ? Integer.MAX_VALUE : right.val;
            if (leftValue <= rightValue) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        return result.next;
    }
}
