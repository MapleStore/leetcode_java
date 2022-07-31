package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SuggestedProducts_1268 {
  private static class Node {
    private Set<String> words = new TreeSet<>();
    private Node[] children = new Node[26];
  }
  private Node root = new Node();
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    for (String product : products) {
      setWord(product);
    }
    List<List<String>> result = new LinkedList<>();
    getWords(searchWord, 0, root, result);
    return result;
  }

  public void getWords(String searchWord, int index, Node node, List<List<String>> result) {
    if (index == searchWord.length()) {
      return;
    }
    char current = searchWord.charAt(index);
    Node nextNode = node.children[current-'a'];
    if (nextNode == null) {
      while (index++ < searchWord.length()) {
        result.add(new LinkedList<>());
      }
      return;
    }
    List<String> oneResult = new LinkedList<>();
    for (String word : nextNode.words) {
      oneResult.add(word);
      if (oneResult.size() >= 3) {
        break;
      }
    }
    result.add(oneResult);
    getWords(searchWord, index+1, nextNode, result);
  }

  public void setWord(String word) {
    if (word.length() == 0) {
      root.words.add("");
    }
    setWord(word, 0, root);
  }

  private void setWord(String word, int index, Node node) {
    if (index == word.length()) {
      return;
    }
    char current = word.charAt(index);
    Node nextNode = node.children[current-'a'];
    if (nextNode == null) {
      nextNode = new Node();
      node.children[current-'a'] = nextNode;
    }
    nextNode.words.add(word);
    setWord(word, index+1, nextNode);
  }

}
