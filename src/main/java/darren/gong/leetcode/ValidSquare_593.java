package darren.gong.leetcode;

public class ValidSquare_593 {
  // 593. 有效的正方形
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    if (equals(p1, p2) || equals(p1, p3) || equals(p1, p4) || equals(p2, p3) || equals(p2, p4) || equals(p3, p4)) {
      return false;
    }
    int disP1P2 = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    int disP1P3 = (p1[0]-p3[0])*(p1[0]-p3[0])+(p1[1]-p3[1])*(p1[1]-p3[1]);
    int disP1P4 = (p1[0]-p4[0])*(p1[0]-p4[0])+(p1[1]-p4[1])*(p1[1]-p4[1]);

    int maxDis = Math.max(Math.max(disP1P2, disP1P3), disP1P4);
    if (maxDis == disP1P2) {
      return checkValid(p1, p2, p3, p4);
    } else if (maxDis == disP1P3) {
      return checkValid(p1, p3, p2, p4);
    } else {
      return checkValid(p1, p4, p2, p3);
    }
  }
  private boolean checkValid(int[] p1, int[] p2, int[] mid1, int[] mid2) {
    int disP1Mid1 = (p1[0]-mid1[0])*(p1[0]-mid1[0])+(p1[1]-mid1[1])*(p1[1]-mid1[1]);
    int disP1Mid2 = (p1[0]-mid2[0])*(p1[0]-mid2[0])+(p1[1]-mid2[1])*(p1[1]-mid2[1]);

    int disP2Mid1 = (p2[0]-mid1[0])*(p2[0]-mid1[0])+(p2[1]-mid1[1])*(p2[1]-mid1[1]);
    int disP2Mid2 = (p2[0]-mid2[0])*(p2[0]-mid2[0])+(p2[1]-mid2[1])*(p2[1]-mid2[1]);

    int disP1P2 = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    return disP1Mid1 == disP1Mid2 && disP2Mid1 == disP2Mid2 && disP1Mid1 == disP2Mid2 && disP1P2 == disP1Mid1+disP2Mid1;
  }
  private boolean equals(int[] p1, int[] p2) {
    return p1[0] == p2[0] && p1[1] == p2[1];
  }
}
