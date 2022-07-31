package darren.gong.leetcode;

public class MaximumBinaryString_1702 {
  public static void main(String[] args) {
    MaximumBinaryString_1702 maximumBinaryString_1702 = new MaximumBinaryString_1702();
    maximumBinaryString_1702.maximumBinaryString("1");
  }
  public String maximumBinaryString(String binary) {
    char[] arr = binary.toCharArray();
    int length = arr.length;
    char[] result = new char[length];
    int resultIndex = 0;
    int currentIndex = binary.indexOf('0');
    if (currentIndex == -1) {
      return binary;
    }
    while (resultIndex < currentIndex) {
      result[resultIndex++] = '1';
    }
    for (; currentIndex < arr.length-1; currentIndex++) {
      if (arr[currentIndex] == '0' && arr[currentIndex+1] == '0') {
        result[resultIndex++] = '1';
      } else {
        break;
      }
    }
    int count = 0;
    for (int i = length-1; i > currentIndex; i--) {
      if (arr[i] == '0') {
        count++;
      }
    }
    while (count-- > 0) {
      result[resultIndex++] = '1';
    }
    result[resultIndex++] = '0';
    while (resultIndex < length) {
      result[resultIndex++] = '1';
    }
    return new String(result);
  }
}
