package darren.gong.leetcode;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem588 {
  public static void main(String[] args) {
    FileSystem588 fileSystem588 = new FileSystem588();
    fileSystem588.mkdir("/a/b/c");
    fileSystem588.addContentToFile("/a/b/c/d", "hello");
    fileSystem588.ls("/");
  }
  private static class Node {
    private Map<String, Node> map = new HashMap<>();
    private boolean isFile = false;
    private StringBuilder content;
  }
  private Node root = new Node();
  public FileSystem588() {

  }

  public List<String> ls(String path) {
    List<String> result = new ArrayList<>();
    Node node = getNode(path);
    if (node.isFile) {
      path = path.substring(path.lastIndexOf("/")+1);
      result.add(path);
      return result;
    }
    for (String key : node.map.keySet()) {
      result.add(key);
    }
    Collections.sort(result);
    return result;
  }

  public void mkdir(String path) {
    String[] paths = path.substring(1).split("/");
    mkdir(paths, 0, root);
  }

  private void mkdir(String[] paths, int index, Node node) {
    if (index >= paths.length) {
      return;
    }
    String path = paths[index];
    Node nextNode = node.map.get(path);
    if (nextNode == null) {
      nextNode = new Node();
      node.map.put(path, nextNode);
    }
    mkdir(paths, index+1, nextNode);
  }

  public void addContentToFile(String filePath, String content) {
    mkdir(filePath);
    Node node = getNode(filePath);
    node.isFile = true;
    if (node.content == null) {
      node.content = new StringBuilder(content);
    } else {
      node.content.append(content);
    }
  }

  public String readContentFromFile(String filePath) {
    Node node = getNode(filePath);
    return node.content.toString();
  }

  private Node getNode(String path) {
    if (path.equals("/")) {
      return root;
    }
    String[] paths = path.substring(1).split("/");
    return getNode(paths, 0, root);
  }

  private Node getNode(String[] paths, int index, Node node) {
    if (index >= paths.length) {
      return node;
    }
    return getNode(paths, index+1, node.map.get(paths[index]));
  }
}
