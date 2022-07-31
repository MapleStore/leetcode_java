package darren.gong.leetcode.interview;

public class Partition_0204 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ListNode returnHead = new ListNode(-1);
    ListNode returnTail = returnHead;

    ListNode newHead = new ListNode(-1);
    newHead.next = head;
    ListNode current = newHead;
    while (current.next != null) {
      if (current.next.val >= x) {
        current = current.next;
        continue;
      }

      ListNode replaceNode = current.next;
      current.next = replaceNode.next;

      returnTail.next = replaceNode;
      returnTail = returnTail.next;
    }
    returnTail.next = newHead.next;
    return returnHead.next;
  }
}
