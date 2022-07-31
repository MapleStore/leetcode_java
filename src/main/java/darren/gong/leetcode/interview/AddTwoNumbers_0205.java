package darren.gong.leetcode.interview;

public class AddTwoNumbers_0205 {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(-1);
    ListNode current = result;
    int increase = 0;
    while (l1 != null || l2 != null || increase != 0) {
      int val = increase;
      if (l1 != null) {
        val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        val += l2.val;
        l2 = l2.next;
      }
      current.next = new ListNode(val%10);
      current = current.next;
      increase = val/10;
    }
    return result.next;
  }
}
