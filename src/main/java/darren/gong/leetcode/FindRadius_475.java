package darren.gong.leetcode;

import java.util.Arrays;

public class FindRadius_475 {
  public static void main(String[] args) {
    FindRadius_475 findRadius_475 = new FindRadius_475();
    findRadius_475.findRadius(new int[]{1,2,3,4}, new int[]{1,4});
  }
  public int findRadius(int[] houses, int[] heaters) {
    int houseLen = houses.length;
    int heaterLen = heaters.length;

    // 1:house 2:heater
    int allPlacesLen = houseLen+heaterLen;
    int index = 0;
    int[][] allPlaces = new int[allPlacesLen][2];
    for (int house : houses) {
      allPlaces[index++] = new int[]{house, 1};
    }
    for (int heater : heaters) {
      allPlaces[index++] = new int[]{heater, 2};
    }
    Arrays.sort(allPlaces, (a,b)->a[0]-b[0]);
    int[] max = new int[allPlacesLen];
    Arrays.fill(max, Integer.MAX_VALUE);
    // count max distance that heater after house
    for (int i = 0; i < allPlacesLen; i++) {
      int[] house = allPlaces[i];
      if (house[1] == 2) {
        continue;
      }
      int heaterIndex = findNextHeaterIndex(allPlaces, i+1);
      if (heaterIndex == -1) {
        break;
      }
      for (int j = i; j < heaterIndex; j++) {
        if (allPlaces[j][1] == 1) {
          max[j] = Math.min(max[j], allPlaces[heaterIndex][0] - allPlaces[j][0]);
        }
      }
      i = heaterIndex;
    }
    // count max distance that house after heater
    for (int i = allPlacesLen-1; i >= 0; i--) {
      int[] house = allPlaces[i];
      if (house[1] == 2) {
        continue;
      }
      int heaterIndex = findLastHeaterIndex(allPlaces, i-1);
      if (heaterIndex == -1) {
        break;
      }
      for (int j = i; j > heaterIndex; j--) {
        if (allPlaces[j][1] == 1) {
          max[j] = Math.min(max[j], allPlaces[j][0]-allPlaces[heaterIndex][0]);
        }
      }
      i = heaterIndex;
    }
    int result = Integer.MIN_VALUE;
    for (int val : max) {
      if (val != Integer.MAX_VALUE) {
        result = Math.max(val, result);
      }
    }
    return result;
  }
  private int findNextHeaterIndex(int[][] allPlaces, int startIndex) {
    for (int i = startIndex; i < allPlaces.length; i++) {
      if (allPlaces[i][1] == 2) {
        return i;
      }
    }
    return -1;
  }
  private int findLastHeaterIndex(int[][] allPlaces, int startIndex) {
    for (int i = startIndex; i >= 0; i--) {
      if (allPlaces[i][1] == 2) {
        return i;
      }
    }
    return -1;
  }
}
