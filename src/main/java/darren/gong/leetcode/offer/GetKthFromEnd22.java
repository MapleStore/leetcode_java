package darren.gong.leetcode.offer;

public class GetKthFromEnd22 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode temp = head;
    while (k-- > 0) {
      temp = temp.next;
    }
    ListNode result = head;
    while (temp != null) {
      result = result.next;
      temp = temp.next;
    }
    return result;
  }
}
