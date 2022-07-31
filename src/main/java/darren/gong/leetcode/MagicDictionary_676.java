package darren.gong.leetcode;

public class MagicDictionary_676 {
  public static void main(String[] args) {
    MagicDictionary_676 magicDictionary_676 = new MagicDictionary_676();
    magicDictionary_676.buildDict(new String[]{"hello","leetcode"});
    magicDictionary_676.search("hhllo");
  }
  private static class Node {
    private boolean isLeaf;
    private Node[] children = new Node[26];
  }
  private Node root = new Node();

  public MagicDictionary_676() {

  }

  public void buildDict(String[] dictionary) {
    for (String word : dictionary) {
      add(root, word, 0);
    }
  }

  private void add(Node node, String value, int index) {
    if (index >= value.length()) {
      node.isLeaf = true;
      return;
    }
    int current = value.charAt(index)-'a';
    if (node.children[current] == null) {
      node.children[current] = new Node();
    }
    add(node.children[current], value, index+1);
  }

  public boolean search(String searchWord) {
    return search(root, searchWord, 0, 1);
  }
  private boolean search(Node node, String searchWord, int currentIndex, int ignoreNum) {
    if (node == null) {
      return false;
    }
    if (currentIndex >= searchWord.length()) {
      if (node.isLeaf && ignoreNum == 0) {
        return true;
      }
      return false;
    }

    Node current = node.children[searchWord.charAt(currentIndex)-'a'];
    boolean result = search(current, searchWord, currentIndex+1, ignoreNum);
    if (ignoreNum == 0) {
      return result;
    }

    for (Node next : node.children) {
      if (next == current) {
        continue;
      }
      result |= search(next, searchWord, currentIndex+1, ignoreNum-1);
    }
    return result;
  }
}
