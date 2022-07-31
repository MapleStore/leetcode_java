package darren.gong.leetcode;

public class MaxDistToClosest849 {
  public int maxDistToClosest(int[] seats) {
    int length = seats.length;
    int[] left = new int[length];
    int[] right = new int[length];
    if (seats[0] == 1) {
      left[0] = 0;
    } else {
      left[0] = Integer.MAX_VALUE;
    }

    if (seats[length-1] == 1) {
      right[length-1] = 0;
    } else {
      right[length-1] = Integer.MAX_VALUE;
    }

    for (int i = 1; i < length; i++) {
      left[i] = seats[i] == 1 ? 0 : left[i-1]+1;
    }
    for (int i = length-2; i >= 0; i--) {
      right[i] = seats[i] == 1 ? 0 : right[i+1]+1;
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      result = Math.max(result, Math.min(left[i], right[i]));
    }
    return result;
  }
}
