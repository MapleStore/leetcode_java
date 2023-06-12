package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubsequenceRepeatedK_2014 {
  public static void main(String[] args) {
    LongestSubsequenceRepeatedK_2014 longestSubsequenceRepeatedK_2014 = new LongestSubsequenceRepeatedK_2014();
    longestSubsequenceRepeatedK_2014.longestSubsequenceRepeatedK("enkkdmnenkkdonenkkdnenkkdnenkkdnendkkdnenkkzxdonenkkdnenwkbkdnenkkdnenkkdnejlnkkdnenkkdnenkkdnenkkdnzenkkdcnenkkbnfdnjednekkdnenkkdnenkvekdnaenknxkudnenkmkdnenkkdpnfenkkdnenkkdnenkrkddnenkjkadnenkkudknkenkkdnenlkkcednsenkkdnenkkdnenkkdnenkkdnvenkkdnenkkqdnxenkkkdnleenkkdnedknykkdnenkkddnfpeenkkdnenklkdnaenkkdnenkkdnenkkduunenkkdnenkkxdnenkkdnenkkdnvenkhekdnenkkdnenkkdnednkkdnenkkdnenkkdnsenkkdenenkkddnenkkdnenkkdneznkkdnenkkdnenkkdnenkkdsnenkkdnenkdkdnenkkdenenkkdnenkkjdnenkxkdnenkkpdnenkkdxnenkkdnenkkdnpenkkdnenkkdnenknkdkyfnenkkidnenokkdnenkkdsnenkkdneznkkdnenkkdnenkkdpnenkkdnsenhkfkdnecnkkdnenkkdnenkkdnenkkdneenkkdnenkkdnenkkdneenkkdnenvkukdndeqnkkndnenkkxdnenkkdnenfkkdnenkkdnyenkkrdnensdkkdnenkkdnvenkkdnenkkzdnenkkndn"
        ,105);
  }
  private int k;
  private Set<String> results = new TreeSet<>((a,b)->{
    if (a.length() == b.length()) {
      return b.compareTo(a);
    } else {
      return b.length()-a.length();
    }
  });
  public String longestSubsequenceRepeatedK(String s, int k) {
    this.k = k;
    int length = s.length();
    if (length < k) {
      return "";
    }
    int[] counts = new int[26];
    int[][] afterCounts = new int[length][26];
    for (int i = s.length()-1; i >= 0; i--) {
      counts[s.charAt(i)-'a']++;
      afterCounts[i] = Arrays.copyOf(counts, counts.length);
    }
    int[] nexts = new int[26];
    Arrays.fill(nexts, -1);
    int[][] nextIndexs = new int[length+1][26];
    for (int i = s.length()-1; i >= 0; i--) {
      nextIndexs[i+1] = Arrays.copyOf(nexts, nexts.length);
      nexts[s.charAt(i)-'a'] = i+1;
    }
    nextIndexs[0] = nexts;
    dfs(s, 0, new StringBuilder(), new int[26], afterCounts, nextIndexs);
    return results.iterator().next();
  }
  private void dfs(String s, int startIndex, StringBuilder sb, int[] currentCounts, int[][] afterCounts, int[][] nextIndexs) {
    if (results.contains(sb.toString()) || !checkValid(nextIndexs, sb.toString())) {
      return;
    }
    results.add(sb.toString());
    for (int index = startIndex; index < s.length()-1; index++) {
      int current = s.charAt(index)-'a';
      currentCounts[current]++;
      if (!checkCanAdd(currentCounts, afterCounts, index)) {
        currentCounts[current]--;
        continue;
      }
      sb.append((char)(current+'a'));
      dfs(s, index+1, sb, currentCounts, afterCounts, nextIndexs);
      currentCounts[current]--;
      sb.deleteCharAt(sb.length()-1);
    }
  }
  private boolean checkValid(int[][] nextIndexs, String result) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < k; i++) {
      sb.append(result);
    }

    int index = 0;
    for (char oneChar : sb.toString().toCharArray()) {
      if (nextIndexs[index][oneChar-'a'] == -1) {
        return false;
      }
      index = nextIndexs[index][oneChar-'a'];
    }
    return true;
  }
  private boolean checkCanAdd(int[] currentCounts, int[][] afterCounts, int index) {
    for (int current = 0; current < currentCounts.length; current++) {
      if (afterCounts[index+1][current] < (k-1)*currentCounts[current]) {
        return false;
      }
    }
    return true;
  }
}
