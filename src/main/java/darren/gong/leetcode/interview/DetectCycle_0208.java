package darren.gong.leetcode.interview;

public class DetectCycle_0208 {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
  }
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode one = head;
    ListNode two = head;
    while (true) {
      if (one.next == null) {
        return null;
      }
      if (two.next == null || two.next.next == null) {
        return null;
      }
      one = one.next;
      two = two.next.next;
      if (one == two) {
        break;
      }
    }
    one = head;
    while (one != two) {
      one = one.next;
      two = two.next;
    }
    return one;
  }
}
