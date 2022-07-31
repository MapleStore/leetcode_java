package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindow_239 {
  public void demo(int[] nums, int windowLength) {
    int length = nums.length;
    int right = 0;
    int left = 0;
    while (right < length) {
      // 将nums[right]加入某个集合
      /* xxxxx */

      // 集合范围超出要求的 删除
      if (right-left+1 > windowLength) {
        // 从集合中取出当前nums[left]
        /* xxxxx */
        left++;
      }
      // 获取当前窗口需要的结果
      /* xxxxx */

      right++;
    }
    return;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int length = nums.length;
    int[] result = new int[length-k+1];
    int resultIndex = 0;

    int right = 0;
    int left = 0;
    LinkedList<Integer> list = new LinkedList<>();
    while (right < length) {
      // 将nums[right]加入某个集合
      list.addLast(nums[right]);

      // 集合范围超出要求的 删除
      if (right-left >= k) {
        list.removeFirst();
        left++;
      }

      // 获取当前窗口中 需要的结果
      if (right >= k-1) {
        int max = Integer.MIN_VALUE;
        for (Integer val : list) {
          max = Math.max(max, val);
        }
        result[resultIndex++] = max;
      }
      right++;
    }
    return result;
  }

  public int[] maxSlidingWindow1(int[] nums, int k) {
    int length = nums.length;
    int[] result = new int[length-k+1];
    int resultIndex = 0;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->b[1]-a[1]);
    int right = 0;
    int left = 0;
    while (right < length) {
      // 将nums[right]加入某个集合
      priorityQueue.add(new int[]{right, nums[right]});

      // 集合范围超出要求的 删除
      if (right-left >= k) {
        left++;
      }
      while (priorityQueue.peek()[0] < left) {
        priorityQueue.poll();
      }
      // 获取当前窗口中 需要的结果
      if (right >= k-1) {
        result[resultIndex++] = priorityQueue.peek()[1];
      }
      right++;
    }
    return result;
  }

  public int[] maxSlidingWindow2(int[] nums, int k) {
    int length = nums.length;
    int[] result = new int[length-k+1];
    int resultIndex = 0;

    Deque<int[]> deque = new LinkedList<>();
    int right = 0;
    int left = 0;
    while (right < length) {
      // 将nums[right]加入某个集合
      while (deque.size() > 0 && deque.peekLast()[1] <= nums[right]) {
        deque.pollLast();
      }
      deque.addLast(new int[]{right, nums[right]});

      // 集合范围超出要求的 删除
      if (right-left >= k) {
        left++;
      }
      while (deque.peekFirst()[0] < left) {
        deque.pollFirst();
      }

      // 获取当前窗口中 需要的结果
      if (right >= k-1) {
        result[resultIndex++] = deque.peekFirst()[1];
      }
      right++;
    }
    return result;
  }

  public int[] maxSlidingWindow3(int[] nums, int k) {
    int n = nums.length;
    int[] prefixMax = new int[n];
    int[] suffixMax = new int[n];
    for (int i = 0; i < n; ++i) {
      if (i % k == 0) {
        prefixMax[i] = nums[i];
      }
      else {
        prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
      }
    }
    for (int i = n - 1; i >= 0; --i) {
      if (i == n - 1 || (i + 1) % k == 0) {
        suffixMax[i] = nums[i];
      } else {
        suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
      }
    }

    int[] ans = new int[n - k + 1];
    for (int i = 0; i <= n - k; ++i) {
      ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
    }
    return ans;
  }
}
