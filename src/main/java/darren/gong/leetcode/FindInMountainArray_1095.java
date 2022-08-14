package darren.gong.leetcode;

public class FindInMountainArray_1095 {
  abstract class MountainArray {
    public int get(int index) {return 0;}
    public int length() {return 0;}
  }

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int length = mountainArr.length();
    if (length < 10) {
      for (int i = 0; i < length; i++) {
        if (mountainArr.get(i) == target) {
          return i;
        }
      }
      return -1;
    }

    int left = 0;
    int leftVal = mountainArr.get(0);
    int right = length-1;
    int rightVal = mountainArr.get(right);
    // get top or bottom
    while (left < right) {
      int mid = (left+right)>>1;
      int midVal = mountainArr.get(mid);

      if (leftVal > midVal && midVal > rightVal) {
        right = mid;
        rightVal = midVal;
      } else if (leftVal < midVal && midVal < rightVal) {
        left = mid;
        leftVal = midVal;
      } else if (mid == left || mid == right) {
        if (midVal > rightVal) {
          right = left;
          rightVal = leftVal;
        } else {
          left = right;
          leftVal = rightVal;
        }
      } else {
        int midLeftVal = mountainArr.get(mid-1);
        if (midLeftVal < midVal) {
          left = mid;
          leftVal = midVal;
        } else {
          right = mid;
          rightVal = midVal;
        }
      }
    }
    int top = left;
    // left == right == top
    left = 0;
    right = top;
    while (left <= right) {
      int mid = (left+right)>>1;
      int midVal = mountainArr.get(mid);
      if (midVal == target) {
        return mid;
      } else if (midVal > target) {
        right = mid-1;
      } else {
        left = mid+1;
      }
    }

    left = top;
    right = length-1;
    while (left <= right) {
      int mid = (left+right)>>1;
      int midVal = mountainArr.get(mid);
      if (midVal == target) {
        return mid;
      } else if (midVal > target) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    return -1;
  }
}
