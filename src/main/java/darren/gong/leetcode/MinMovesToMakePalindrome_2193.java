package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMovesToMakePalindrome_2193 {
  public static void main(String[] args) {
    MinMovesToMakePalindrome_2193 minMovesToMakePalindrome_2193 = new MinMovesToMakePalindrome_2193();
    minMovesToMakePalindrome_2193.minMovesToMakePalindrome("aabb");
  }
  public int minMovesToMakePalindrome(String s) {
    char[] chars = s.toCharArray();
    int left = 0;
    int right = s.length()-1;
    int result = 0;
    while (left < right) {
      int[] leftIndex = new int[26];
      Arrays.fill(leftIndex, 99999);
      for (int i = left; i <= right; i++) {
        int leftChar = chars[i]-'a';
        if (leftIndex[leftChar] == 99999) {
          leftIndex[leftChar] = i;
        }
      }
      int minLeft = right;
      int minRight = left;
      for (int i = right; i >= 0; i--) {
        int rightChar = chars[i]-'a';
        if ((leftIndex[rightChar]-left)+(right-i) < (minLeft-left)+(right-minRight)) {
          minLeft = leftIndex[rightChar];
          minRight = i;
        }
      }
      result += (minLeft-left)+(right-minRight);
      while (minLeft > left) {
        char temp = chars[minLeft];
        chars[minLeft] = chars[minLeft-1];
        chars[minLeft-1] = temp;
        minLeft--;
      }
      while (minRight < right) {
        char temp = chars[minRight];
        chars[minRight] = chars[minRight+1];
        chars[minRight+1] = temp;
        minRight++;
      }

      left++;
      right--;
    }
    return result;
  }
}
