package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class AdvantageCount870 {
  public static void main(String[] args) {
    AdvantageCount870 advantageCount870 = new AdvantageCount870();
    advantageCount870.advantageCount(new int[]{2,0,4,1,2}, new int[]{1,3,0,0,2});
  }
  public int[] advantageCount(int[] A, int[] B) {
    Arrays.sort(A);
    int length = A.length;
    int[] result = new int[length];
    TreeMap<Integer, Queue<Integer>> treeMap = new TreeMap<>();
    for (int i = 0; i < length; i++) {
      Queue<Integer> indexs = treeMap.get(B[i]);
      if (indexs == null) {
        indexs = new LinkedList<>();
        treeMap.put(B[i], indexs);
      }
      indexs.add(i);
    }
    int indexA = 0;
    boolean[] visited = new boolean[length];
    Queue<Integer> remain = new LinkedList<>();
    for (int key : treeMap.keySet()) {
      Queue<Integer> indexs = treeMap.get(key);
      int size = indexs.size();
      while (size-- > 0) {
        while (indexA < length && A[indexA] <= key) {
          remain.add(indexA);
          indexA++;
        }
        if (indexA == length) {
          break;
        }
        int indexB = indexs.poll();
        result[indexB] = A[indexA];
        visited[indexB] = true;
        indexA++;
      }
    }
    for (int i = 0; i < length; i++) {
      if (!visited[i]) {
        result[i] = A[remain.poll()];
      }
    }
    return result;
  }
}
