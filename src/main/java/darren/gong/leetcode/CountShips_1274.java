package darren.gong.leetcode;

public class CountShips_1274 {
  class Sea {
    public boolean hasShips(int[] topRight, int[] bottomLeft){
      return true;
    }
  }

  public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
    int result = 0;
    int top = topRight[0];
    int bottom = bottomLeft[0];
    int left = bottomLeft[1];
    int right = topRight[1];
    while (left <= right) {
      while (left < right) {
        int mid = (left+right+1)>>1;
        boolean hasShips = sea.hasShips(new int[]{top, right}, new int[]{bottom, mid});
        if (hasShips) {
          left = mid;
        } else {
          right = mid-1;
        }
      }
      result += countShips(sea, top, bottom, left);
      right = left-1;
      left = bottomLeft[1];
    }
    return result;
  }
  private int countShips(Sea sea, int top, int bottom, int line) {
    int result = 0;
    int tempTop = top;
    int tempBottom = bottom;
    while (tempBottom <= tempTop) {
      while (tempBottom < tempTop) {
        int mid = (tempTop+tempBottom-1)>>1;
        boolean hasShips = sea.hasShips(new int[]{mid, line}, new int[]{tempBottom, line});
        if (hasShips) {
          tempTop = mid;
        } else {
          tempBottom = mid+1;
        }
      }
      result += sea.hasShips(new int[]{tempTop, line}, new int[]{tempBottom, line}) ? 1 : 0;
      tempBottom = tempTop+1;
      tempTop = top;
    }
    return result;
  }

}
