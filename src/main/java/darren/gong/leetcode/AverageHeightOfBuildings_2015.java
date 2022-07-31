package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class AverageHeightOfBuildings_2015 {
  public static void main(String[] args) {
    AverageHeightOfBuildings_2015 averageHeightOfBuildings_2015 = new AverageHeightOfBuildings_2015();
    averageHeightOfBuildings_2015.averageHeightOfBuildings(new int[][]{{1,4,2},{3,9,4}});
  }
  public int[][] averageHeightOfBuildings(int[][] buildings) {
    // int[] : buildings num, height sum
    TreeMap<Integer, int[]> map = new TreeMap<>();
    for (int[] building : buildings) {
      int[] start = map.computeIfAbsent(building[0], k->new int[2]);
      start[0]++;
      start[1] += building[2];

      int[] end = map.computeIfAbsent(building[1], k->new int[2]);
      end[0]--;
      end[1] -= building[2];
    }

    ArrayList<int[]> tempResult = new ArrayList<>();
    int preIndex = -1;
    int preAverage = 0;
    int buildingNum = 0;
    int height = 0;
    for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
      int pointIndex = entry.getKey();
      buildingNum += entry.getValue()[0];
      height += entry.getValue()[1];
      int currentAvg = buildingNum == 0 ? 0 : height/buildingNum;
      if (preIndex == -1) {
        preIndex = pointIndex;
        preAverage = currentAvg;
        continue;
      }

      if (currentAvg != preAverage) {
        if (preAverage != 0) {
          tempResult.add(new int[]{preIndex, pointIndex, preAverage});
        }
        preIndex = pointIndex;
        preAverage = currentAvg;
      }
    }
    int[][] result = new int[tempResult.size()][];
    return tempResult.toArray(result);
  }
}
