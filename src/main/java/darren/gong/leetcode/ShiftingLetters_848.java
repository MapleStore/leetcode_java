package darren.gong.leetcode;

public class ShiftingLetters_848 {
  public static void main(String[] args) {
    ShiftingLetters_848 shiftingLetters_848 = new ShiftingLetters_848();
    shiftingLetters_848.shiftingLetters("abckdisngkshoangkshoangkdjfosdngksd",
        new int[]{3,5,9987986,3234,453,234,234,23423,34,45,7,687,45,342,6756,34,53,5,3,5,34,6,7,67,98,3,434,2,3,5,34,6,7,67,98});
  }
  public String shiftingLetters(String s, int[] shifts) {
    char[] chars = s.toCharArray();
    int length = s.length();

    long changeSum = 0;
    for (int i = length-1; i >= 0; i--) {
      changeSum += shifts[i];
      changeSum = changeSum%26;
      chars[i] = (char)(chars[i]+changeSum > 'z' ? chars[i]+changeSum-26 : chars[i]+changeSum);
    }
    return new String(chars);
  }
}
