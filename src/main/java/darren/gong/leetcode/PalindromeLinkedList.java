package darren.gong.leetcode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (two != null && two.next != null) {
            one = one.next;
            two= two.next.next;
        }
        if (two != null) {
            one = one.next;
        }

        ListNode cut = head;
        while (cut.next != one) {
            cut = cut.next;
        }
        cut.next = null;

        ListNode reverHead = new ListNode(-1);
        while (one != null) {
            ListNode next = one.next;
            one.next = reverHead.next;
            reverHead.next = one;
            one = next;
        }
        reverHead = reverHead.next;
        while (head != null && reverHead != null) {
            if (head.val != reverHead.val) {
                return false;
            }
            head = head.next;
            reverHead = reverHead.next;
        }
        return true;
    }

}
