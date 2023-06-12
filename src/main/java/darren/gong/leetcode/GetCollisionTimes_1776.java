package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class GetCollisionTimes_1776 {
  public static void main(String[] args) {
    GetCollisionTimes_1776 getCollisionTimes_1776 = new GetCollisionTimes_1776();
    getCollisionTimes_1776.getCollisionTimes(new int[][]{{12,4},{14,1},{16,5},{17,3},{18,2},{20,4}});
  }
  private static class Node {
    int index;
    int position;
    int speed;
    double timeToNext;
    Node next;
    Node pre;
  }
  public double[] getCollisionTimes(int[][] cars) {
    int length = cars.length;
    double[] result = new double[length];
    result[length-1] = -1;
    Node head = new Node();
    Node current = head;
    TreeMap<Double, TreeMap<Integer, Node>> treeMap = new TreeMap<>();
    for (int i = 0; i < length; i++) {
      Node newNode = new Node();
      newNode.index = i;
      newNode.position = cars[i][0];
      newNode.speed = cars[i][1];
      if (i != length-1) {
        newNode.timeToNext =
            cars[i][1] <= cars[i+1][1] ? Double.MAX_VALUE : (double) (cars[i+1][0]-cars[i][0])/(double) (cars[i][1]-cars[i+1][1]);
        treeMap.computeIfAbsent(newNode.timeToNext, k->new TreeMap<>()).put(newNode.index, newNode);
      }
      newNode.pre = current;
      current.next = newNode;
      current = newNode;
    }
    while (!treeMap.isEmpty()) {
      TreeMap<Integer, Node> map = treeMap.firstEntry().getValue();
      Node node = map.pollFirstEntry().getValue();
      map.remove(node.index);
      if (map.isEmpty()) {
        treeMap.remove(node.timeToNext);
      }

      if (node.timeToNext == Double.MAX_VALUE) {
        result[node.index] = -1;
      } else {
        result[node.index] = node.timeToNext;
        if (node.pre != head) {
          treeMap.get(node.pre.timeToNext).remove(node.pre.index);
          if (treeMap.get(node.pre.timeToNext).size() == 0) {
            treeMap.remove(node.pre.timeToNext);
          }

          node.pre.timeToNext =
              node.pre.speed <= node.next.speed ? Double.MAX_VALUE : (double) (node.next.position-node.pre.position)/(double) (node.pre.speed-node.next.speed);

          treeMap.computeIfAbsent(node.pre.timeToNext, k->new TreeMap<>()).put(node.pre.index, node.pre);
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
      }
    }
    return result;
  }
}
