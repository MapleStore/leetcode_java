package darren.gong.leetcode;

import java.util.Arrays;

public class PathSumIV_666 {
  // 666. 路径总和 IV
  public int pathSum(int[] nums) {
    int[] tree = new int[32];
    Arrays.fill(tree, -1);
    for (int num : nums) {
      int value = num%10;
      int pos = (num/10)%10;
      int level = num/100;

      tree[(int)Math.pow(2, level-1)-1+pos] = value;
    }
    int result = 0;
    for (int i = 0; i < 32; i++) {
      if (tree[i] == -1) {
        continue;
      }
      if (tree[i/2] != -1) {
        tree[i] += tree[i/2];
      }

      if ((2*i >= 32 || tree[2*i] == -1) && (2*i+1 >= 32 || tree[2*i+1] == -1)) {
        result += tree[i];
      }
    }
    return result;
  }
}
