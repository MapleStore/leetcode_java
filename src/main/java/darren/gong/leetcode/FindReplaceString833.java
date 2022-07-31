package darren.gong.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class FindReplaceString833 {
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    TreeMap<Integer, String[]> treeMap = new TreeMap<>();
    int size = indexes.length;
    for (int i = 0; i < size; i++) {
      treeMap.put(indexes[i], new String[]{sources[i], targets[i]});
    }

    StringBuilder sb = new StringBuilder(S);
    int deviation = 0;
    for (Map.Entry<Integer, String[]> entry : treeMap.entrySet()) {
      String changeSource = entry.getValue()[0];
      int indexSource = entry.getKey();
      String changeTarget = entry.getValue()[1];

      if (S.indexOf(changeSource, indexSource) == indexSource) {
        sb.replace(deviation+indexSource, deviation+indexSource+changeSource.length(), changeTarget);
        deviation += changeTarget.length()-changeSource.length();
      }
    }
    return sb.toString();
  }
}
