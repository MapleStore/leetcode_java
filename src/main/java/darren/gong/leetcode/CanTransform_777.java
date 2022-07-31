package darren.gong.leetcode;

public class CanTransform_777 {
  public static void main(String[] args) {
    CanTransform_777 canTransform_777 = new CanTransform_777();
    canTransform_777.canTransform("XXXXXXXXLXXXXXXRXXXX", "XXXXXXXXXLXXXXXRXXXX");
  }
  public boolean canTransform(String start, String end) {
    if (!start.replaceAll("X", "").equals(end.replaceAll("X", ""))) {
      return false;
    }
    int startIndex = 0;
    int endIndex = 0;
    char[] newStart = start.toCharArray();
    char[] newEnd = end.toCharArray();
    while (true) {
      int endRIndex = getCharIndex(newEnd, endIndex, 'R');
      int startRIndex = getCharIndex(newStart, startIndex, 'R');
      if (endRIndex < startRIndex) {
        return false;
      }
      if (startRIndex == Integer.MAX_VALUE) {
        break;
      }
      startIndex = startRIndex+1;
      endIndex = endRIndex+1;
    }
    startIndex = 0;
    endIndex = 0;
    while (true) {
      int endLIndex = getCharIndex(newEnd, endIndex, 'L');
      int startLIndex = getCharIndex(newStart, startIndex, 'L');
      if (endLIndex > startLIndex) {
        return false;
      }
      if (startLIndex == Integer.MAX_VALUE) {
        break;
      }
      startIndex = startLIndex+1;
      endIndex = endLIndex+1;
    }
    return true;
  }

  private int getCharIndex(char[] arr, int startIndex, char target) {
    for (int i = startIndex; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return Integer.MAX_VALUE;
  }
}
