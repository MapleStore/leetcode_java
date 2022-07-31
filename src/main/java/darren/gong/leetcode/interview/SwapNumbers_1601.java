package darren.gong.leetcode.interview;

public class SwapNumbers_1601 {
  public int[] swapNumbers(int[] numbers) {
    numbers[0] += numbers[1];
    numbers[1] = numbers[0]-numbers[1];
    numbers[0] -= numbers[1];
    return numbers;
  }
}
