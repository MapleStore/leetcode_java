package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubdomainVisits_811 {
  public static void main(String[] args) {
    SubdomainVisits_811 subdomainVisits_811 = new SubdomainVisits_811();
    subdomainVisits_811.subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
  }
  private static class Node {
    private int count;
    private Map<String, Node> nodes = new HashMap<>();
  }
  private Node root = new Node();
  public List<String> subdomainVisits(String[] cpdomains) {
    for (String cpDomain : cpdomains) {
      String[] countAndDomains = cpDomain.split(" ");
      String[] domains = countAndDomains[1].split("\\.");
      add(root, domains, domains.length-1, Integer.parseInt(countAndDomains[0]));
    }
    List<String> result = new LinkedList<>();
    getResult(root, "", result);
    return result;
  }
  private void add(Node node, String[] domains, int index, int count) {
    if (index < 0) {
      return;
    }
    String domain = domains[index];
    Node nextNode = node.nodes.computeIfAbsent(domain, k->new Node());
    nextNode.count += count;
    add(nextNode, domains, index-1, count);
  }
  private void getResult(Node node, String suffix, List<String> result) {
    if (suffix.length() != 0) {
      suffix = "."+suffix;
    }
    for (Map.Entry<String, Node> entry : node.nodes.entrySet()) {
      result.add(entry.getValue().count+" "+entry.getKey()+suffix);
      getResult(entry.getValue(), entry.getKey()+suffix, result);
    }
  }
}
