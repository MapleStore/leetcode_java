package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilterRestaurants_1333 {
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    List<int[]> result = new LinkedList<>(Arrays.asList(restaurants));
    if (veganFriendly == 1) {
      result.removeIf(restaurant -> restaurant[2] == 0);
    }
    result.removeIf(restaurant -> restaurant[3] > maxPrice);
    result.removeIf(restaurant -> restaurant[4] > maxDistance);
    Collections.sort(result, (a,b)->{
      if (a[1] == b[1]) {
        return b[0]-a[0];
      } else {
        return b[1]-a[1];
      }
    });
    List<Integer> realResult = new LinkedList<>();
    for (int[] restaurant : result) {
      realResult.add(restaurant[0]);
    }
    return realResult;
  }
}
