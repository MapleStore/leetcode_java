package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OuterTrees_587 {
  public static void main(String[] args) {
    OuterTrees_587 outerTrees_587 = new OuterTrees_587();
    outerTrees_587.outerTrees1(new int[][]{{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}});
  }

  public int[][] outerTrees1(int[][] trees) {
    List<int[]> result = new ArrayList<>();
    int resultIndex = 0;
    int[] start = null;
    for (int[] tree : trees) {
      if (start == null || (tree[0] < start[0] || (tree[0] == start[0] && tree[1] < start[1]))) {
        start = tree;
      }
    }
    result.add(start);

    int[] finalStart = start;
    Arrays.sort(trees, (a, b)->{
      int[] vector1 = new int[]{a[0]- finalStart[0], a[1]- finalStart[1]};
      int[] vector2 = new int[]{b[0]- finalStart[0], b[1]- finalStart[1]};
      if (vector1[0]*vector2[1] == vector1[1]*vector2[0]) {
        return (vector1[0]*vector1[0]+vector1[1]*vector1[1])-(vector2[0]*vector2[0]+vector2[1]*vector2[1]);
      } else {
        return vector1[0]*vector2[1]-vector1[1]*vector2[0];
      }
    });
    int i = trees.length-2;
    for (; i >= 0; i--) {
      int[] vectorPre = new int[]{trees[i+1][0]- finalStart[0], trees[i+1][1]- finalStart[1]};
      int[] vector = new int[]{trees[i][0]- finalStart[0], trees[i][1]- finalStart[1]};
      if (vector[0]*vectorPre[1] != vector[1]*vectorPre[0]) {
        break;
      }
    }
    reverse(trees, i+1);

    for (int[] tree : trees) {
      if (equals(tree, start)) {
        continue;
      }
      while (resultIndex >= 1) {
        int[] vector1 = new int[]{result.get(resultIndex)[0]-result.get(resultIndex-1)[0], result.get(resultIndex)[1]-result.get(resultIndex-1)[1]};
        int[] vector2 = new int[]{tree[0]-result.get(resultIndex)[0], tree[1]-result.get(resultIndex)[1]};
        if (vector2[0]*vector1[1] >= vector1[0]*vector2[1]) {
          break;
        } else {
          result.remove(resultIndex);
          resultIndex--;
        }
      }
      result.add(tree);
      resultIndex++;
    }
    int[][] results = new int[result.size()][];
    resultIndex = 0;
    for (int[] one : result) {
      results[resultIndex++] = one;
    }
    return results;
  }
  private void reverse(int[][] trees, int left) {
    int right = trees.length-1;
    while (left < right) {
      int[] temp = trees[left];
      trees[left] = trees[right];
      trees[right] = temp;
      left++;
      right--;
    }
  }
  private boolean equals(int[] point1, int[] point2) {
    return point1[0]==point2[0] && point1[1]==point2[1];
  }

  boolean[] visited;
  int length;
  int startIndex;
  public int[][] outerTrees(int[][] trees) {
    this.length = trees.length;
    this.visited = new boolean[length];
    List<Integer> resultIndexs = new ArrayList<>();
    startIndex = -1;
    for (int i = 0; i < trees.length; i++) {
      int[] tree = trees[i];
      if (startIndex == -1 || tree[0] < trees[startIndex][0]) {
        startIndex = i;
      }
    }
    resultIndexs.add(startIndex);
    visited[startIndex] = true;
    int currentIndex = startIndex;
    while ((currentIndex = getLeft(currentIndex, trees)) != -1) {
      resultIndexs.add(currentIndex);
      visited[currentIndex] = true;
    }
    int[][] results = new int[resultIndexs.size()][];
    for (int i = 0; i < resultIndexs.size(); i++) {
      results[i] = trees[resultIndexs.get(i)];
    }
    return results;
  }
  private int getLeft(int currentIndex, int[][] trees) {
    int[] currentTree = trees[currentIndex];
    int next = -1;
    for (int i = 0; i < length; i++) {
      if (visited[i]) {
        continue;
      }
      if (next == -1) {
        next = i;
        continue;
      }
      int[] currentToNext = new int[]{trees[next][0]-currentTree[0], trees[next][1]-currentTree[1]};
      int[] currentToI = new int[]{trees[i][0]-currentTree[0], trees[i][1]-currentTree[1]};
      if (currentToNext[0]*currentToI[1] > currentToNext[1]*currentToI[0]) {
        next = i;
      } else if (currentToNext[0]*currentToI[1] == currentToNext[1]*currentToI[0] &&
          currentToI[0]*currentToI[0]+currentToI[1]*currentToI[1] < currentToNext[0]*currentToNext[0]+currentToNext[1]*currentToNext[1]) {
        next = i;
      }
    }
    if (next == -1) {
      return -1;
    }
    int[] currentToNext = new int[]{trees[next][0]-currentTree[0], trees[next][1]-currentTree[1]};
    int[] currentToStart = new int[]{trees[startIndex][0]-currentTree[0], trees[startIndex][1]-currentTree[1]};
    if (currentToStart[0]*currentToNext[1] < currentToStart[1]*currentToNext[0]) {
      return -1;
    }
    return next;
  }
}
