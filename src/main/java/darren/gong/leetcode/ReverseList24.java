package darren.gong.leetcode;

public class ReverseList24 {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode result = new ListNode(-1);
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      current.next = result.next;
      result.next = current;
      current = next;
    }
    return result.next;
  }
}
