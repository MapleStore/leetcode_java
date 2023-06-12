package darren.gong.leetcode;

public class MaxScoreWords_1255 {
  public int maxScoreWords(String[] words, char[] letters, int[] score) {
    int[] allSum = new int[26];
    for (char letter : letters) {
      allSum[letter-'a']++;
    }
    int length = words.length;
    int[][] wordsSum = new int[length][26];
    for (int i = 0; i < length; i++) {
      for (char letter : words[i].toCharArray()) {
        wordsSum[i][letter-'a']++;
      }
    }
    int result = 0;
    for (int mask = 1; mask < 1<<length; mask++) {
      int[] currentSum = new int[26];
      for (int current = 0; current < length; current++) {
        if ((1<<current & mask) == 0) {
          continue;
        }
        for (int i = 0; i < 26; i++) {
          currentSum[i] += wordsSum[current][i];
        }
      }
      int maskResult = 0;
      for (int i = 0; i < 26; i++) {
        if (currentSum[i] > allSum[i]) {
          maskResult = 0;
          break;
        }
        maskResult += currentSum[i]*score[i];
      }
      result = Math.max(result, maskResult);
    }
    return result;
  }
}
