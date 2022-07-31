package darren.gong.leetcode;

public class NearestPalindromic564 {
  public static void main(String[] args) {
    NearestPalindromic564 nearestPalindromic564 = new NearestPalindromic564();
    nearestPalindromic564.nearestPalindromic("100");
  }
  public String nearestPalindromic(String n) {
    if (n == null || n.length() == 0) {
      return "-1";
    }
    long value = Long.parseLong(n);
    if (value == 0) {
      return 1+"";
    }
    if (value <= 10) {
      return (value-1)+"";
    }
    String palindromic = getPalindromic(n);
    long palindromicValue = Long.parseLong(palindromic);
    long palindromicDiff = Math.abs(palindromicValue-value);

    long upPalindromicValue = Long.parseLong(getUpPalindromic(n));
    long upPalindromicDiff = Math.abs(upPalindromicValue-value);

    long downPalindromicValue = Long.parseLong(getDownPalindromic(n));
    long downPalindromicDiff = Math.abs(downPalindromicValue-value);

    if (palindromic.equals(n)) {
      return downPalindromicDiff > upPalindromicDiff ? upPalindromicValue+"" : downPalindromicValue+"";
    } else if (palindromicValue > value) {
      return downPalindromicDiff > palindromicDiff ? palindromicValue+"" : downPalindromicValue+"";
    } else {
      return palindromicDiff > upPalindromicDiff ? upPalindromicValue+"" : palindromicValue+"";
    }
  }

  private String getPalindromic(String n) {
    int length = n.length();
    int mid = length>>>1;
    if (length%2 == 0) {
      StringBuilder leftHalf = new StringBuilder(n.substring(0, mid));
      return String.valueOf(leftHalf) + leftHalf.reverse();
    }
    StringBuilder leftHalf = new StringBuilder(n.substring(0, mid));
    return n.substring(0, mid+1)+leftHalf.reverse().toString();
  }

  private String getUpPalindromic(String n) {
    char[] nArr = n.toCharArray();
    int halfIndex = (n.length()-1)>>>1;
    int increaseIndex = halfIndex;
    while (increaseIndex >= 0 && nArr[increaseIndex] == '9') {
      nArr[increaseIndex] = '0';
      increaseIndex--;
    }
    if (increaseIndex == -1) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n.length(); i++) {
        sb.append(9);
      }
      return Long.parseLong(sb.toString())+2+"";
    }
    nArr[increaseIndex] += 1;
    StringBuilder pre = new StringBuilder().append(nArr).delete(halfIndex+1, n.length());
    if (nArr.length % 2 == 0) {
      return new StringBuilder().append(pre).append(pre.reverse()).toString();
    } else {
      return new StringBuilder().append(pre).append(pre.deleteCharAt(pre.length()-1).reverse()).toString();
    }
  }

  private String getDownPalindromic(String n) {
    char[] nArr = n.toCharArray();
    int halfIndex = (n.length()-1)>>>1;
    int decreaseIndex = halfIndex;
    while (decreaseIndex >= 0 && nArr[decreaseIndex] == '0') {
      nArr[decreaseIndex] = '9';
      decreaseIndex--;
    }
    if (decreaseIndex == 0 && nArr[0] == '1') {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n.length()-1; i++) {
        sb.append(9);
      }
      return sb.toString();
    }
    nArr[decreaseIndex] -= 1;
    StringBuilder pre = new StringBuilder().append(nArr).delete(halfIndex+1, n.length());
    if (nArr.length % 2 == 0) {
      return new StringBuilder().append(pre).append(pre.reverse()).toString();
    } else {
      return new StringBuilder().append(pre).append(pre.deleteCharAt(pre.length()-1).reverse()).toString();
    }
  }
}
