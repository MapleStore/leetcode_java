package darren.gong.leetcode;

public class OddEvenList_328 {
  // 328. 奇偶链表
  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    ListNode now = listNode;
    for (int i = 2; i <= 5; i++) {
      now.next = new ListNode(i);
      now = now.next;
    }
    OddEvenList_328 oddEvenList328 = new OddEvenList_328();
    oddEvenList328.oddEvenList2(listNode);
  }

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode nowOne = head;
    ListNode twoHead = head.next;
    ListNode nowTwo = head.next;
    while (nowTwo != null && nowTwo.next != null) {
      ListNode twoNext = nowTwo.next;
      nowOne.next = nowTwo.next;
      nowTwo.next = nowTwo.next.next;
      twoNext.next = twoHead;
      nowOne = nowOne.next;
      nowTwo = nowTwo.next;
    }
    return head;
  }

  public ListNode oddEvenList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode nowOne = new ListNode(-1);
    ListNode nowTwo = new ListNode(-1);

    ListNode twoHead = head.next;

    ListNode current = head;
    int i = 1;
    while (current != null) {
      if (current != null && i == 1) {
        nowOne.next = current;
        current = current.next;
        nowOne = nowOne.next;
        nowOne.next = null;
        i = 3-i;
      }
      if (current != null && i == 2) {
        nowTwo.next = current;
        current = current.next;
        nowTwo = nowTwo.next;
        nowTwo.next = null;
        i = 3-i;
      }
    }
    nowOne.next = twoHead;
    return head;
  }
}
