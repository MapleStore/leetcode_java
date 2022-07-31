package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AlienOrder269 {
  public static void main(String[] args) {
    AlienOrder269 alienOrder269 = new AlienOrder269();
    //alienOrder269.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
    alienOrder269.alienOrder(new String[]{"ac","ab","b"});
    //alienOrder269.alienOrder(new String[]{"z","x","y"});
    //alienOrder269.alienOrder(new String[]{"z","z"});
  }
  public String alienOrder(String[] words) {
    for (int i = 0; i < words.length; i++) {
      if (words[i].isEmpty() && i-1 >= 0 && !words[i-1].isEmpty()) {
        return "";
      }
    }
    boolean[][] graph = new boolean[26][26];
    if (!generateGraph(new ArrayList<>(Arrays.asList(words)), 0, graph)) {
      return "";
    }

    int[] outNums = new int[26];
    boolean[] visited = new boolean[26];
    Arrays.fill(visited, true);
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        if (graph[i][j]) {
          outNums[i]++;
          visited[i] = false;
          visited[j] = false;
        }
      }
    }

    for (String word : words) {
      for (char oneChar : word.toCharArray()) {
        if (visited[getIndexFromChar(oneChar)]) {
          visited[getIndexFromChar(oneChar)] = false;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int nextToTake;
    while ((nextToTake = getNextToTake(outNums, visited)) != -1) {
      sb.append((char) ('a'+nextToTake));
      for (int i = 0; i < 26; i++) {
        if (graph[i][nextToTake]) {
          outNums[i]--;
        }
      }
    }
    if (containsNotVisited(visited)) {
      return "";
    }
    return sb.reverse().toString();
  }
  private boolean containsNotVisited(boolean[] visited) {
    for (int i = 0; i < 26; i++) {
      if (!visited[i]) {
        return true;
      }
    }
    return false;
  }
  private int getNextToTake(int[] outNums, boolean[] visited) {
    for (int i = 0; i < 26; i++) {
      if (!visited[i] && outNums[i] == 0) {
        visited[i] = true;
        return i;
      }
    }
    return -1;
  }
  private boolean generateGraph(List<String> list, int index, boolean[][] result) {
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().length() <= index) {
        iterator.remove();
      }
    }
    int size = list.size();
    if (list.size() <= 1) {
      return true;
    }

    int preIndex = 0;
    for (int i = preIndex+1; i < size; i++) {
      char preChar = list.get(preIndex).charAt(index);
      char currentChar = list.get(i).charAt(index);

      if (preChar != currentChar) {
        List<String> nextList = new ArrayList<>();
        for (int j = preIndex; j < i; j++) {
          nextList.add(list.get(j));
        }

        result[getIndexFromChar(preChar)][getIndexFromChar(currentChar)] = true;
        if (!generateGraph(nextList, index+1, result)) {
          return false;
        }
        preIndex = i;
      } else if (index+1 == list.get(i).length() && index+1 != list.get(i-1).length()) {
        return false;
      }
    }
    List<String> nextList = new ArrayList<>();
    for (int j = preIndex; j < size; j++) {
      nextList.add(list.get(j));
    }
    if (!generateGraph(nextList, index+1, result)) {
      return false;
    }
    return true;
  }
  private int getIndexFromChar(char charIndex) {
    return charIndex-'a';
  }
}
