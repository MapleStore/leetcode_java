package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class FindLadders126 {
  private int length = Integer.MAX_VALUE;
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> paths = new HashMap<>();
    paths.put(beginWord, new HashSet<>());
    paths.put(endWord, new HashSet<>());
    for (String word : wordList) {
      paths.put(word, new HashSet<>());
      if (isNeighbour(word, beginWord)) {
        paths.get(beginWord).add(word);
      }
    }

    for (String word1 : wordList) {
      for (String word2 : wordList) {
        if (isNeighbour(word1, word2)) {
          paths.get(word1).add(word2);
          paths.get(word2).add(word1);
        }
      }
    }

    List<List<String>> result = new ArrayList<>();

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    boolean findResult = false;
    Map<String, Set<String>> wordToParents = new HashMap<>();
    queue.add(beginWord);

    while (!findResult && !queue.isEmpty()) {
      int size = queue.size();
      Set<String> nextLevel = new HashSet<>();
      while (size-- > 0) {
        String current = queue.poll();
        for (String nextWord : paths.get(current)) {
          if (!wordToParents.containsKey(nextWord)) {
            wordToParents.put(nextWord, new HashSet<>());
          }
          if (visited.contains(nextWord) && !nextLevel.contains(nextWord)) {
            continue;
          }
          wordToParents.get(nextWord).add(current);
          nextLevel.add(nextWord);
          if (nextWord.equals(endWord)) {
            findResult = true;
          }
          visited.add(nextWord);
          queue.add(nextWord);
        }
      }
    }
    if (findResult) {
      getResult(result, wordToParents, endWord, beginWord, new Stack<>());
    }
    return result;
  }

  private List<String> getResult(Stack<String> stack) {
    List<String> result = new LinkedList<>();
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }

  private void getResult(List<List<String>> result, Map<String, Set<String>> wordToParents, String currentWord, String stopWord, Stack<String> oneResult) {
    oneResult.push(currentWord);
    if (currentWord.equals(stopWord)) {
      List<String> temp = new ArrayList<>(oneResult);
      Collections.reverse(temp);
      result.add(temp);
      oneResult.pop();
      return;
    }
    for (String parent : wordToParents.get(currentWord)) {
      getResult(result, wordToParents, parent, stopWord, oneResult);
    }
    oneResult.pop();
    return;
  }

  private boolean isNeighbour(String s1, String s2) {
    boolean result = false;
    int index = 0;
    for (; index < s1.length(); index++) {
      if (s1.charAt(index) != s2.charAt(index)) {
        if (result) {
          return false;
        }
        result = true;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    FindLadders126 findLadders126 = new FindLadders126();
    findLadders126.findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
  }

  private void backTracking(Map<String, Set<String>> paths, Set<String> visited, String current, String end, List<List<String>> result, List<String> oneResult, int currentLength) {
    if (currentLength >= length) {
      return;
    }
    oneResult.add(current);
    visited.add(current);
    if (end.equals(current)) {
      length = Math.min(length, currentLength+1);
      result.add(new LinkedList<>(oneResult));
      visited.remove(current);
      oneResult.remove(oneResult.size()-1);
      return;
    }
    Set<String> nextWords = paths.get(current);
    for (String nextWord : nextWords) {
      if (visited.contains(nextWord)) {
        continue;
      }
      backTracking(paths, visited, nextWord, end, result, oneResult, currentLength+1);
    }
    visited.remove(current);
    oneResult.remove(oneResult.size()-1);
    return;
  }

}
