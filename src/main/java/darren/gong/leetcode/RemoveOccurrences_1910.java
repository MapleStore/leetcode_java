package darren.gong.leetcode;

public class RemoveOccurrences_1910 {
  public static void main(String[] args) {
    RemoveOccurrences_1910 removeOccurrences_1910 = new RemoveOccurrences_1910();
    removeOccurrences_1910.removeOccurrences("axxxxyyyyb", "xy");
  }
  public String removeOccurrences(String s, String part) {
    int partLen = part.length();
    int[] nexts = new int[partLen];
    for (int i = 1, j = 0; i < partLen; i++) {
      while (j > 0 && part.charAt(i) != part.charAt(j)) j = nexts[j-1];
      if (part.charAt(i) == part.charAt(j)) j++;
      nexts[i] = j;
    }

    StringBuilder sb = new StringBuilder(s);
    for (int i = 0, j = 0; i < sb.length(); ) {
      while (j > 0 && (j == partLen || sb.charAt(i) != part.charAt(j))) j = nexts[j-1];
      if (sb.charAt(i) == part.charAt(j)) j++;
      if (j == partLen) {
        sb.delete(i-partLen+1, i+1);
        i = 0;
        j = 0;
      } else {
        i++;
      }
    }
    return sb.toString();
  }
}
