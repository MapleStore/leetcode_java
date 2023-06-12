package darren.gong.leetcode;

import java.util.Arrays;

public class MinimumEffort_1665 {
  public static void main(String[] args) {
    MinimumEffort_1665 minimumEffort_1665 = new MinimumEffort_1665();
    minimumEffort_1665.minimumEffort(new int[][]{{1,3},{2,4},{10,11},{10,12},{8,9}});
  }
  // 用式子推导 task[1]-task[0]比较大的 一定早于小的执行比较好
  // 反证法
  // 如果最优解中包含 有一个task[1]-task[0]比较大的 设为task:a
  // 晚于task[1]-task[0]比较小的 设为task:b 能成功执行执行
  // 则两者调换顺序必然也能执行 所以按task[1]-task[0]从小到大执行必然最优
  public int minimumEffort(int[][] tasks) {
    Arrays.sort(tasks, (a,b)->{
      return (a[1]-a[0])-(b[1]-b[0]);
    });
    int realUse = 0;
    int need = 0;
    for (int[] task : tasks) {
      need = Math.max(Math.max(realUse, need)+task[0], task[1]);
      realUse += task[0];

    }
    return need;
  }
}
