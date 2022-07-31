package darren.gong.leetcode;

public class Partition86 {
    public static void main(String[] args) {
        Partition86 partition86 = new Partition86();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        partition86.partition(head, 4);
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode tail = smallHead;

        ListNode bigHead = new ListNode(-1);
        bigHead.next = head;
        ListNode pre = bigHead;

        while (pre != null && pre.next != null) {
            if (pre.next.val < x) {
                ListNode smallNode = pre.next;
                pre.next = pre.next.next;
                smallNode.next = tail.next;
                tail.next = smallNode;

                tail = tail.next;
            } else {
                pre = pre.next;
            }
        }
        tail.next = bigHead.next;
        return smallHead.next;
    }
}
