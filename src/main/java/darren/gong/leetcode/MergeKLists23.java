package darren.gong.leetcode;

public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }
        return mergeKLists(lists, 0, lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end < start) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid+1, end);
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
