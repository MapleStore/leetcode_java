package darren.gong.leetcode;

public class PartitionDisjoint_915 {
  public static void main(String[] args) {
    int[] A = new int[]{5,0,3,8,6};
    PartitionDisjoint_915 partitionDisjoint_915 = new PartitionDisjoint_915();
    partitionDisjoint_915.partitionDisjoint(A);
  }
  // 915. 分割数组
  public int partitionDisjoint(int[] A) {
    int length = A.length;
    int[] big = new int[length];
    int[] small = new int[length];
    big[0] = A[0];
    small[length-1] = A[length-1];
    for (int i = 1; i < length; i++) {
      big[i] = Math.max(big[i-1], A[i]);
    }
    for (int i = length-2; i >= 0; i--) {
      small[i] = Math.min(small[i+1], A[i]);
    }
    for (int i = 0; i < length-1; i++) {
      if (big[i] <= small[i+1]) {
        return i+1;
      }
    }
    return -1;
  }

  public int partitionDisjoint2(int[] A) {
    int length = A.length;
    int leftMax = A[0];
    int pos = 0;
    int max = A[0];
    for (int i = 1; i < length; i++) {
      max = Math.max(max, A[i]);
      if (A[i] < leftMax) {
        pos = i;
        leftMax = max;
      }
    }
    return pos+1;
  }
}
