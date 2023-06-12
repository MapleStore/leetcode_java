package darren.gong.leetcode;

public class NumPoints_1453 {
  public static void main(String[] args) {
    NumPoints_1453 numPoints_1453 = new NumPoints_1453();
    numPoints_1453.numPoints(new int[][]{{-2,0},{2,0},{0,2},{0,-2}}, 2);
  }

  private static class Point {
    double x;
    double y;
    private Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public int numPoints(int[][] darts, int r) {
    int length = darts.length;
    if (length == 1) {
      return 1;
    }
    int result = 1;
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        Point[] points = getPoints(darts[i][0], darts[i][1], darts[j][0], darts[j][1], r);
        if (points == null) {
          continue;
        }
        for (Point one : points) {
          int count = 0;
          for (int[] dart : darts) {
            if (countDistance(dart[0], dart[1], one.x, one.y) <= r) {
              count++;
            }
          }
          result = Math.max(result, count);
        }
      }
    }
    return result;
  }

  private Point[] getPoints(double x1, double y1, double x2, double y2, double r) {
    if (2*r < countDistance(x1, y1, x2, y2)) {
      return null;
    }
    if (x1 == x2 && y1 == y2) {
      return new Point[]{new Point(x1, y1), new Point(x1, y1)};
    }
    if (x1 == x2) {
      return new Point[]{new Point(x1+Math.sqrt(r*r-((y1-y2)*(y1-y2)/4)), (y1+y2)/2),
          new Point(x1-Math.sqrt(r*r-((y1-y2)*(y1-y2)/4)), (y1+y2)/2)};
    }
    if (y1 == y2) {
      return new Point[]{new Point((x1+x2)/2, y1+(r*r-((x1-x2)*(x1-x2)/4))), new Point((x1+x2)/2, y1-(r*r-((x1-x2)*(x1-x2)/4)))};
    }

    // y = kx+b
    double k = -(x2-x1)/(y2-y1);
    double b = (y2*y2-y1*y1+x2*x2-x1*x1)/(2*(y2-y1));

    // Ax^2+Bx+C = 0
    double A = 1+(k*k);
    double B = (2*k*b-2*x1-2*y1*k);
    double C = (x1*x1+b*b+y1*y1-2*y1*b-r*r);
    double xResult1 = (-B+Math.sqrt(B*B-4*A*C))/(2*A);
    double xResult2 = (-B-Math.sqrt(B*B-4*A*C))/(2*A);

    double yResult1 = k*xResult1+b;
    double yResult2 = k*xResult2+b;
    return new Point[]{new Point(xResult1, yResult1), new Point(xResult2, yResult2)};
  }
  private double countDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
  }
}
