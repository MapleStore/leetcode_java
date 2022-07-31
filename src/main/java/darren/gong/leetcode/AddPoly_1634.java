package darren.gong.leetcode;

public class AddPoly_1634 {
  class PolyNode {
    int coefficient, power;
    PolyNode next = null;

    PolyNode() {}
    PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
    PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
  }

  public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
    PolyNode head = new PolyNode();
    PolyNode pre = head;
    while (poly1 != null && poly2 != null) {
      if (poly1.power == poly2.power) {
        PolyNode add = new PolyNode(poly1.coefficient+poly2.coefficient, poly1.power);
        if (add.coefficient != 0) {
          pre.next = add;
          pre = pre.next;
        }
        poly1 = poly1.next;
        poly2 = poly2.next;
      } else if (poly1.power > poly2.power) {
        pre.next = poly1;
        poly1 = poly1.next;
        pre = pre.next;
      } else {
        pre.next = poly2;
        poly2 = poly2.next;
        pre = pre.next;
      }
    }
    if (poly1 != null) {
      pre.next = poly1;
    } else if (poly2 != null) {
      pre.next = poly2;
    } else {
      pre.next = null;
    }
    return head.next;
  }
}
