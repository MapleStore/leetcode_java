package darren.gong.leetcode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null || curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return null;
    }
}
