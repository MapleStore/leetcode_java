package darren.gong.leetcode;

public class CheckOverlap_1401 {
  public static void main(String[] args) {
    CheckOverlap_1401 checkOverlap_1401 = new CheckOverlap_1401();
    checkOverlap_1401.checkOverlap(1206, -5597,-276, -5203,-1795,-4648,1721);
  }
  //1206 -5597 -276 -5203 -1795 -4648 1721
  public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
    int[] circleUp = new int[]{x_center, y_center+radius};
    int[] circleDown = new int[]{x_center, y_center-radius};
    int[] circleLeft = new int[]{x_center-radius, y_center};
    int[] circleRight = new int[]{x_center+radius, y_center};
    if (checkPosInRec(circleUp[0], circleUp[1], x1, y1, x2, y2) ||
        checkPosInRec(circleDown[0], circleDown[1], x1, y1, x2, y2) ||
        checkPosInRec(circleLeft[0], circleLeft[1], x1, y1, x2, y2) ||
        checkPosInRec(circleRight[0], circleRight[1], x1, y1, x2, y2)) {
      return true;
    }
    int[] recLeftUp = new int[]{x1, y2};
    int[] recLeftDown = new int[]{x1, y1};
    int[] recRightUp = new int[]{x2, y2};
    int[] recRightDown = new int[]{x2, y1};
    if (checkPosInCircle(recLeftUp[0], recLeftUp[1], radius, x_center, y_center) ||
        checkPosInCircle(recLeftDown[0], recLeftDown[1], radius, x_center, y_center) ||
        checkPosInCircle(recRightUp[0], recRightUp[1], radius, x_center, y_center) ||
        checkPosInCircle(recRightDown[0], recRightDown[1], radius, x_center, y_center)) {
      return true;
    }

    if (circleLeft[0]<x1 && circleRight[0]>x2 && circleLeft[1]>y1 && circleRight[1]<y2 ||
        circleUp[1]>y2 && circleDown[1]<y1 && circleUp[0]>x1 && circleUp[0]<x2) {
      return true;
    }
    return false;
  }
  private boolean checkPosInRec(int x, int y, int x1, int y1, int x2, int y2) {
    return x >= x1 && x <= x2 && y >= y1 && y <= y2;
  }
  private boolean checkPosInCircle(int x, int y, int radius, int x_center, int y_center) {
    int distanceY = radius*radius-(x-x_center)*(x-x_center);
    return distanceY >= (y-y_center)*(y-y_center);
  }
}
