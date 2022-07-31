package darren.gong.leetcode;

import java.util.List;

public class ZigzagIterator281 {
  private int[] index;
  private List<Integer>[] lists;
  private int max;
  private int current = 0;
  private int currentList = 0;
  public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {
    lists = new List[2];
    lists[0] = v1;
    lists[1] = v2;
    index = new int[2];
    max = v1.size()+v2.size();
  }

  public int next() {
    while (true) {
      if (index[currentList] >= lists[currentList].size()) {
        currentList = (currentList+1) % index.length;
        continue;
      }
      int result = lists[currentList].get(index[currentList]);
      index[currentList]++;
      current++;
      currentList = (currentList+1) % index.length;
      return result;
    }
  }

  public boolean hasNext() {
    return current < max;
  }

}
