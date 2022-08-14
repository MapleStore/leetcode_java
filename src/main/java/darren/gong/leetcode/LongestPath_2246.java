package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestPath_2246 {
  public static void main(String[] args) {
    LongestPath_2246 longestPath_2246 = new LongestPath_2246();
    longestPath_2246.longestPath(new int[] {-1,156,5,200,41,259,221,25,196,86,165,194,201,90,207,121,145,222,211,181,90,231,10,209,90,195,90,149,174,150,11,105,49,191,98,87,249,205,233,2,79,96,195,214,101,121,138,231,212,139,54,61,105,200,233,159,95,105,259,41,41,13,249,73,86,258,111,151,115,221,212,80,211,29,132,30,207,57,235,90,105,128,157,9,145,194,235,181,41,124,214,191,245,31,150,158,0,119,13,169,17,42,38,18,91,195,132,155,99,226,85,235,216,216,141,207,101,194,31,137,256,114,233,110,191,88,120,123,21,257,220,242,31,244,31,114,187,208,33,137,96,54,10,201,164,12,148,133,216,31,10,52,191,205,195,52,5,223,185,12,93,133,81,246,28,194,242,137,254,41,71,1,78,30,244,205,43,43,154,198,101,192,133,188,6,64,141,240,235,232,123,194,30,109,52,86,129,3,156,126,249,85,159,56,69,240,112,31,33,151,1,233,195,159,52,135,207,33,59,194,212,110,214,220,41,138,10,80,60,42,50,219,156,105,119,96,163,55,33,257,242,205,90,6,86,246,110,176,75,52,236,96,98,96,179,172,235,161,94,201},
    "ysqlkqhlalzehtojfmzyhgwpimgwzimkrvxtiahfgkeyhslpseckzopfmahcwaokqxhcchcoagftomqzsidvosepjfhdkexeftskbfaewbmacfrvygskbwsumucuqekcgbfbtlxkoijbqehcrkvblawjgjoamboxnhzbzrwopfjduwvjlaiesoshhicgtmhuywyswyaeamuzxazhoxkwwgmwfdljdrajzwjfklqsmgermkrhvdpabrisvybmxrpapmie");
  }
  public int longestPath(int[] parent, String s) {
    char[] chars = s.toCharArray();
    int length = parent.length;
    int[] count = new int[length];
    for (int i = 0; i < length; i++) {
      if (parent[i] == -1) {
        continue;
      }
      count[parent[i]]++;
    }
    Map<Integer, Integer>[] values = new Map[length];
    for (int i = 0; i < length; i++) {
      values[i] = new HashMap<>();
    }
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      if (count[i] == 0) {
        queue.add(new int[]{i, 1});
      }
    }
    while (!queue.isEmpty()) {
      int[] node = queue.poll();
      int current = node[0];
      int next = parent[current];
      if (next == -1) {
        continue;
      }
      if (chars[next] == chars[current]) {
        queue.add(new int[]{next, 1});
        continue;
      }
      queue.add(new int[]{next, node[1]+1});
      values[next].put(current, Math.max(node[1], values[next].getOrDefault(current, 0)));
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      int max = 0;
      int sec = 0;
      for (int val : values[i].values()) {
        if (val >= max) {
          sec = max;
          max = val;
        } else if (val > sec) {
          sec = val;
        }
      }
      result = Math.max(result, 1+max+sec);
    }
    return result;
  }
}
