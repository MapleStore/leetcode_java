package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class AutocompleteSystem642 {
  private class Node {
    Map<Character, Node> charToNode = new HashMap<>();
    boolean end;
  }
  private class Trie {
    private Node root = new Node();
    private void put(String sentence) {
      if (sentence == null) {
        return;
      }
      if (sentence.isEmpty()) {
        root.end = true;
        return;
      }
      putHelper(sentence, 0, root);
    }

    private void putHelper(String sentence, int index, Node node) {
      if (index >= sentence.length()) {
        node.end = true;
        return;
      }
      char currentChar = sentence.charAt(index);
      Node next = node.charToNode.get(sentence.charAt(index));
      if (next == null) {
        next = new Node();
        node.charToNode.put(currentChar, next);
      }
      putHelper(sentence, index+1, next);;
    }

    private List<String> getSentencesByPrefix(String prefix) {
      List<String> result = new ArrayList<>();
      getSentencesByPrefixHelper(prefix, 0, root, result, new StringBuilder());
      return result;
    }

    private void getSentencesByPrefixHelper(String prefix, int index, Node node, List<String> result, StringBuilder oneResult) {
      if (index >= prefix.length()) {
        backTracking(node, result, oneResult.append(prefix));
        return;
      }
      char currentChar = prefix.charAt(index);
      Node next = node.charToNode.get(currentChar);
      if (next == null) {
        return;
      }
      getSentencesByPrefixHelper(prefix, index+1, next, result, oneResult);
    }

    private void backTracking(Node node, List<String> result, StringBuilder oneResult) {
      if (node.end) {
        result.add(oneResult.toString());
      }
      for (Map.Entry<Character, Node> entry : node.charToNode.entrySet()) {
        oneResult.append(entry.getKey());
        backTracking(entry.getValue(), result, oneResult);
        oneResult.deleteCharAt(oneResult.length()-1);
      }
      return;
    }
  }

  private class Entry {
    private int time;
    private String sentence;
    private Entry(int time, String sentence) {
      this.time = time;
      this.sentence = sentence;
    }
  }
  private Trie trie = new Trie();
  private Map<String, Integer> sentenceToTimes = new HashMap<>();
  private StringBuilder sb = new StringBuilder();
  public AutocompleteSystem642(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      String sentence = sentences[i];
      if (sentenceToTimes.containsKey(sentence)) {
        continue;
      }
      sentenceToTimes.put(sentence, times[i]);
      trie.put(sentence);
    }
  }

  public List<String> input(char c) {
    if (c == '#') {
      String sentence = sb.toString();
      sentenceToTimes.put(sentence, sentenceToTimes.getOrDefault(sentence, 0)+1);
      trie.put(sb.toString());
      sb = new StringBuilder();
      return new ArrayList<>();
    }
    sb.append(c);
    List<String> sentences = trie.getSentencesByPrefix(sb.toString());
    PriorityQueue<Entry> queue = new PriorityQueue<Entry>((a,b) -> {
      if (a.time == b.time) {
        return a.sentence.compareTo(b.sentence);
      } else {
        return b.time-a.time;
      }
    });
    for (String sentence : sentences) {
      queue.add(new Entry(sentenceToTimes.get(sentence), sentence));
    }
    List<String> result = new ArrayList<>();
    int index = 0;
    while (index++ < 3 && !queue.isEmpty()) {
      result.add(queue.poll().sentence);
    }
    return result;
  }
}
