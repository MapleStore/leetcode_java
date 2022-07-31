package darren.gong.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class ShortestSeq_1718 {
  // 面试题 17.18. 最短超串
  public static void main(String[] args) {
    ShortestSeq_1718 shortestSeq_1718 = new ShortestSeq_1718();
    shortestSeq_1718.shortestSeq(new int[]{842, 336, 777, 112, 789, 801, 922, 874, 634, 121, 390, 614, 179, 565, 740, 672, 624, 130, 555, 714, 9, 950, 887, 375, 312, 862, 304, 121, 360, 579, 937, 148, 614, 885, 836, 842, 505, 187, 210, 536, 763, 880, 652, 64, 272, 675, 33, 341, 101, 673, 995, 485, 16, 434, 540, 284, 567, 821, 994, 174, 634, 597, 919, 547, 340, 2, 512, 433, 323, 895, 965, 225, 702, 387, 632, 898, 297, 351, 936, 431, 468, 694, 287, 671, 190, 496, 80, 110, 491, 365, 504, 681, 672, 825, 277, 138, 778, 851, 732, 176},
new int[]{950, 885, 702, 101, 312, 652, 555, 936, 842, 33, 634, 851, 174, 210, 287, 672, 994, 614, 732, 919, 504, 778, 340, 694, 880, 110, 777, 836, 365, 375, 536, 547, 887, 272, 995, 121, 225, 112, 740, 567, 898, 390, 579, 505, 351, 937, 825, 323, 874, 138, 512, 671, 297, 179, 277, 304});
  }
  public int[] shortestSeq(int[] big, int[] small) {
    int smallLength = small.length;
    int bigLength = big.length;
    int visitedNum = 0;
    int[] visited = new int[smallLength];
    Map<Integer, Integer> valueToIndex = new HashMap<>();
    for (int i = 0; i < smallLength; i++) {
      valueToIndex.put(small[i], i);
    }

    int[] result = new int[]{-999999, 999999};
    int left = 0;
    int right = 0;
    while (right < bigLength) {
      Integer index = valueToIndex.get(big[right]);
      if (index == null) {
        right++;
        continue;
      }
      if (visited[index] == 0) {
        visitedNum++;
      }
      visited[index]++;
      while (visitedNum >= smallLength) {
        if (right-left < result[1]-result[0]) {
          result = new int[]{left, right};
        }
        Integer leftIndex = valueToIndex.get(big[left]);
        if (leftIndex != null) {
          visited[leftIndex]--;
          if (visited[leftIndex] <= 0) {
            visitedNum--;
          }
        }
        left++;
      }
      right++;
    }
    return result[1] == 999999 ? new int[0] : result;
  }
}
