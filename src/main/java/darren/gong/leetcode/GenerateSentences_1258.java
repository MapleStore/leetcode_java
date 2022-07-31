package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class GenerateSentences_1258 {
  // 1258. 近义词句子
  private List<String> result = new LinkedList<>();
  private Map<String, String> parent = new HashMap<>();
  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    Map<String, TreeSet<String>> map = new HashMap<>();
    String[] array = text.split(" ");
    for (String word : array) {
      parent.putIfAbsent(word, word);
    }
    for (List<String> similar : synonyms) {
      String word1 = similar.get(0);
      String word2 = similar.get(1);
      parent.putIfAbsent(word1, word1);
      parent.putIfAbsent(word2, word2);
      merge(word1, word2);
    }

    for (String word : parent.keySet()) {
      find(word);
    }
    for (Map.Entry<String, String> entry : parent.entrySet()) {
      TreeSet<String> set = map.computeIfAbsent(entry.getValue(), k->new TreeSet<>());
      set.add(entry.getKey());
    }
    backTracking(array, 0, map);
    return result;
  }
  private void backTracking(String[] array, int index, Map<String, TreeSet<String>> map) {
    if (index == array.length) {
      StringBuilder sb = new StringBuilder();
      for (String word : array) {
        if (sb.length() != 0) {
          sb.append(' ');
        }
        sb.append(word);
      }
      result.add(sb.toString());
      return;
    }
    String old = array[index];
    TreeSet<String> replace = map.get(parent.get(old));
    if (replace == null) {
      backTracking(array, index+1, map);
    } else {
      for (String word : replace) {
        array[index] = word;
        backTracking(array, index+1, map);
        array[index] = old;
      }
    }
    return;
  }

  private String find(String word) {
    if (parent.get(word).equals(word)) {
      return word;
    }
    parent.put(word, find(parent.get(word)));
    return parent.get(word);
  }

  private void merge(String word1, String word2) {
    parent.put(parent.get(word1), parent.get(word2));
  }
}
