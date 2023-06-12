package darren.gong.leetcode.race;

public class PartitionString {
  public int partitionString(String s) {
    boolean[] visited = new boolean[26];
    int result = 0;
    for (char oneChar : s.toCharArray()) {
      if (visited[oneChar-'a']) {
        result++;
        visited = new boolean[26];
      }
      visited[oneChar-'a'] = true;
    }
    for (boolean val : visited) {
      if (val) {
        result++;
        break;
      }
    }
    return result;
  }
}
