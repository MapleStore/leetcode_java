package darren.gong.leetcode;

public class Insert708 {
  private class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  };

  public Node insert(Node head, int insertVal) {
    Node node = new Node(insertVal);
    if (head == null) {
      node.next = node;
      return node;
    }
    Node current = head;
    do {
      // 走到末尾
      if (current.next.val < current.val) {
        // 全节点大于等于，或小于等于，插入末尾
        if ((insertVal >= current.val && insertVal > current.next.val) || (insertVal <= current.next.val && insertVal < current.val)) {
          node.next = current.next;
          current.next = node;
          return head;
        }
        // 走到插入节点
      } else if (insertVal >= current.val && insertVal <= current.next.val) {
        node.next = current.next;
        current.next = node;
        return head;
      }
      current = current.next;
    } while (current != head);
    // 全部节点相等
    node.next = head.next;
    head.next = node;
    return head;
  }
}
