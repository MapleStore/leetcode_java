package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisiblePoints_1610 {
  public static void main(String[] args) {
    int pointX = 0;
    int pointY = 0;
    // 4 +360 2 180-x  3 180-x
    System.out.println(Math.toDegrees(Math.asin(pointY/Math.sqrt(pointX*pointX+pointY*pointY))));
  }
  double eps = 1e-9;
  public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
    int x = location.get(0);
    int y = location.get(1);
    List<Double> angles = new ArrayList<>();
    int countSame = 0;
    for (List<Integer> position : points) {
      int pointX = position.get(0)-x;
      int pointY = position.get(1)-y;
      double pointAngle = Math.toDegrees(Math.asin(pointY/Math.sqrt(pointX*pointX+pointY*pointY)));
      if (pointX == 0 && pointY == 0) {
        countSame++;
      } else if (pointX >= 0 && pointY >= 0) {
        // 1
        angles.add(pointAngle);
      } else if (pointX <= 0 && pointY >= 0) {
        // 2
        angles.add(180-pointAngle);
      } else if (pointX <= 0 && pointY <= 0) {
        // 3
        angles.add(180-pointAngle);
      } else {
        angles.add(pointAngle+360);
      }
    }
    int length = angles.size();
    for (int i = 0; i < length; i++) {
      angles.add(angles.get(i)+360);
    }
    Collections.sort(angles);
    int result = 0;
    int left = 0;
    int right = 0;
    while (left < length && right < 2*length) {
      Double rightAngle = angles.get(right);
      while (rightAngle-angles.get(left) > angle+eps) {
        left++;
      }
      result = Math.max(result, right-left+1);
      right++;
    }
    return result+countSame;
  }
}
