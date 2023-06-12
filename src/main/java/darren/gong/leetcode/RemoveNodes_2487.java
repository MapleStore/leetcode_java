package darren.gong.leetcode;

public class RemoveNodes_2487 {
  public ListNode removeNodes(ListNode head) {
    ListNode newHeader = new ListNode(-1);
    newHeader.next = removeNodesHelper(head);
    return newHeader.next;
  }
  private int max = Integer.MIN_VALUE;
  private ListNode removeNodesHelper(ListNode head) {
    if (head == null) {
      return null;
    }
    head.next = removeNodesHelper(head.next);
    if (max > head.val) {
      return head.next;
    }
    max = head.val;
    return head;
  }
}
