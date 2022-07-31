package darren.gong.leetcode.interview;

public class OneEditAway_0105 {
  public static void main(String[] args) {
    System.out.println("aaa".substring(3));
  }
  public boolean oneEditAway(String first, String second) {
    if (Math.abs(first.length()-second.length()) > 1) {
      return false;
    }
    int indexOne = 0;
    int indexTwo = 0;
    while (indexOne < first.length() && indexTwo < second.length() && first.charAt(indexOne) == second.charAt(indexTwo)) {
      indexOne++;
      indexTwo++;
    }
    if (indexOne == first.length() || indexTwo == second.length()) {
      return true;
    }
    return first.substring(indexOne+1).equals(second.substring(indexTwo)) ||
        first.substring(indexOne).equals(second.substring(indexTwo+1)) ||
        first.substring(indexOne+1).equals(second.substring(indexTwo+1));
  }
}
