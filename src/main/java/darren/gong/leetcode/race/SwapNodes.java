package darren.gong.leetcode.race;


public class SwapNodes {
  public static void main(String[] args) {
    SwapNodes swapNodes = new SwapNodes();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    swapNodes.swapNodes(head, 1);
  }
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode swapNodes(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode preHead = new ListNode(-1);
    preHead.next = head;
    ListNode current = preHead;
    int length = 0;
    while (current.next != null) {
      length++;
      current = current.next;
    }
    int preIndex1 = k-1;
    int preIndex2 = length-k;
    if (preIndex1 == preIndex2) {
      return head;
    }
    ListNode pre1 = null;
    ListNode pre2 = null;
    int currentIndex = 0;
    current = preHead;
    while (pre1 == null || pre2 == null) {
      if (currentIndex == preIndex1) {
        pre1 = current;
      }
      if (currentIndex == preIndex2) {
        pre2 = current;
      }
      currentIndex++;
      current = current.next;
    }


    ListNode node1 = pre1.next;
    ListNode node2 = pre2.next;
    if (node1.next == node2) {
      pre1.next = node2.next;
      node1.next = pre1.next;
      node2.next = node1;
      pre1.next = node2;
      return preHead.next;
    } else if (node2.next == node1) {
      pre2.next = node1.next;
      node2.next = pre2.next;
      node1.next = node2;
      pre2.next = node1;
      return preHead.next;
    }

    pre1.next = node1.next;
    pre2.next = node2.next;
    node2.next = pre1.next;
    node1.next = pre2.next;
    pre2.next = node1;
    pre1.next = node2;
    return preHead.next;
  }
}
