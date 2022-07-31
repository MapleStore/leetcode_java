package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FileSystem_1166 {
  private class Node {
    private int value;
    private Map<String, Node> children = new HashMap<>();
    Node(int value) {
      this.value = value;
    }
  }
  private Node root = new Node(-1);
  public FileSystem_1166() {

  }

  public boolean createPath(String path, int value) {
    String[] paths = path.split("/");
    return createPath(paths, 1, value, root);
  }

  private boolean createPath(String[] paths, int currentIndex, int value, Node current) {
    Node next = current.children.get(paths[currentIndex]);
    if (currentIndex == paths.length-1) {
      if (next != null) {
        return false;
      }
      current.children.put(paths[currentIndex], new Node(value));
      return true;
    }

    if (next == null) {
      return false;
    }
    return createPath(paths, currentIndex+1, value, next);
  }

  public int get(String path) {
    String[] paths = path.split("/");
    return get(paths, 1, root);
  }

  private int get(String[] paths, int currentIndex, Node current) {
    Node next = current.children.get(paths[currentIndex]);
    if (currentIndex == paths.length-1) {
      if (next != null) {
        return next.value;
      }
      return -1;
    }

    if (next == null) {
      return -1;
    }
    return get(paths, currentIndex+1, next);
  }
}
