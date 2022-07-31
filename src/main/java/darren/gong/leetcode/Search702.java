package darren.gong.leetcode;

public class Search702 {
   interface ArrayReader {
     public int get(int index);
   }

  public int search(ArrayReader reader, int target) {
    if (reader.get(0) == 2147483647) {
      return -1;
    }
    int minValue = reader.get(0);
    int left = 0;
    int right = target-minValue;
    while (left <= right) {
      int mid = left+((right-left)>>1);
      if (reader.get(mid) == target) {
        return mid;
      } else if (reader.get(mid) > target) {
        right = right-1;
      } else {
        left = mid+1;
      }
    }
    return -1;
  }

}
