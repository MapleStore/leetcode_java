package darren.gong.leetcode;

import java.util.Arrays;

public class FindTheLongestSubstring_1371 {
  // 1371. 每个元音包含偶数次的最长子字符串
  public static void main(String[] args) {
    FindTheLongestSubstring_1371 findTheLongestSubstring_1371 = new FindTheLongestSubstring_1371();
    findTheLongestSubstring_1371.findTheLongestSubstring("eleetminicoworoep");
  }
  private char[] evenNums = new char[]{'a', 'e', 'i', 'o', 'u'};
  public int findTheLongestSubstring(String s) {
    int length = s.length();
    int[] statusToIndex = new int[1<<5];
    Arrays.fill(statusToIndex, Integer.MAX_VALUE);
    statusToIndex[0] = -1;
    char[] arr = s.toCharArray();
    int currentStatus = 0;
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < evenNums.length; j++) {
        if (arr[i] == evenNums[j]) {
          currentStatus ^= (1<<j);
        }
      }
      if (statusToIndex[currentStatus] == Integer.MAX_VALUE) {
        statusToIndex[currentStatus] = i;
        continue;
      }
      result = Math.max(result, i-statusToIndex[currentStatus]);
    }
    return result;
  }

  public int findTheLongestSubstring2(String s) {
    int length = s.length();
    int[][] evenCount = new int[length][26];
    char[] arr = s.toCharArray();
    for (int i = 0; i < length; i++) {
      if (i != 0) {
        for (int evenNum : evenNums) {
          evenCount[i][evenNum] = evenCount[i-1][evenNum];
        }
      }
      evenCount[i][arr[i]-'a']++;
    }

    int[][] evenNextIndex = new int[length][26];
    int[] tempNextIndex = new int[26];
    Arrays.fill(tempNextIndex, -1);
    for (int i = length-1; i >= 0; i--) {
      for (int evenNum : evenNums) {
        evenNextIndex[i][evenNum] = tempNextIndex[evenNum];
      }
      tempNextIndex[arr[i]-'a'] = i;
    }

    int result = 0;
    for (int i = length-1; i >= 0; i--) {
      if (i+1 <= result) {
        break;
      }

      int invalidEven = invalidEven(new int[26], evenCount[i]);
      if (invalidEven == -1) {
        result = Math.max(result, i+1);
        break;
      }
      int start = 0;
      while (start < i) {
        invalidEven = invalidEven(evenCount[start], evenCount[i]);
        if (invalidEven == -1) {
          result = Math.max(result, i-start);
          break;
        } else {
          start = evenNextIndex[start][invalidEven];
        }
      }
    }
    return result;
  }
  private int invalidEven(int[] startEvenCount, int[] endEvenCount) {
    for (int evenNum : evenNums) {
      if ((endEvenCount[evenNum]-startEvenCount[evenNum])%2 != 0) {
        return evenNum;
      }
    }
    return -1;
  }
}
