package darren.gong.leetcode;

public class PlusOne369 {
  public ListNode plusOne(ListNode head) {
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    plusOneHelper(newHead);
    return newHead.val == 0 ? head : newHead;
  }
  private int plusOneHelper(ListNode node) {
    int add = node.next == null ? 1 : plusOneHelper(node.next);
    node.val += add;
    if (node.val == 10) {
      node.val = 0;
      return 1;
    }
    return 0;
  }
}
