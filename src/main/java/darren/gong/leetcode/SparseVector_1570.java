package darren.gong.leetcode;

public class SparseVector_1570 {
  // 1570. 两个稀疏向量的点积
  private int[] nums;
  SparseVector_1570(int[] nums) {
    this.nums = nums;
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector_1570 vec) {
    int[] another = vec.getNums();
    int result = 0;
    int length = this.nums.length;
    for (int i = 0; i < length; i++) {
      result += this.nums[i]*another[i];
    }
    return result;
  }

  public int[] getNums() {
    return nums;
  }
}
