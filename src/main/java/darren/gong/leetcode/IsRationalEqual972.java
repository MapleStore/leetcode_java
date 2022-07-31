package darren.gong.leetcode;

public class IsRationalEqual972 {
  public static void main(String[] args) {
    IsRationalEqual972 isRationalEqual972 = new IsRationalEqual972();
    isRationalEqual972.isRationalEqual("1.9(0)", "1.8(9)");
  }
  private static class Entry {
    private int prePoint;
    private String behindPoint;
    private Entry() {
    }
    private Entry(int prePoint, String behindPoint) {
      this.prePoint = prePoint;
      this.behindPoint = behindPoint;
    }
  }
  public boolean isRationalEqual(String S, String T) {
    Entry sEntry = parseResult(S);
    Entry tEntry = parseResult(T);
    return sEntry.prePoint == tEntry.prePoint && sEntry.behindPoint.equals(tEntry.behindPoint);
  }
  private Entry parseResult(String s) {
    Entry result = new Entry();
    String[] strings = s.split("[.]", -1);
    result.prePoint = Integer.parseInt(strings[0]);
    if (strings.length == 1) {
      result.behindPoint = getBehindPoint("", "0");
      return result;
    }
    if (strings[1].equals("") || strings[1].indexOf('(') == -1) {
      result.behindPoint = getBehindPoint(strings[1], "0");
      return result;
    }
    String[] behindPoint = strings[1].split("[(]", -1);
    String behindPointA = behindPoint[0];
    String behindPointB = behindPoint[1].split("[)]", -1)[0];
    result.behindPoint = getBehindPoint(behindPointA, behindPointB);
    return dealWith9(result);
  }
  private String getBehindPoint(String a, String b) {
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    int bIndex = 0;
    while (sb.length() < 12) {
      sb.append(b.charAt(bIndex));
      bIndex = (bIndex+1)%b.length();
    }
    return sb.toString();
  }
  private Entry dealWith9(Entry pre) {
    if (!pre.behindPoint.endsWith("9999")) {
      return pre;
    }
    if (pre.behindPoint.equals("999999999999")) {
      pre.prePoint++;
      pre.behindPoint = "000000000000";
      return pre;
    }
    char[] arr = pre.behindPoint.toCharArray();
    for (int i = arr.length-1; i >= 0; i--) {
      if (arr[i] == '9') {
        arr[i] = '0';
      } else {
        arr[i]++;
        break;
      }
    }
    pre.behindPoint = new String(arr);
    return pre;
  }
}
