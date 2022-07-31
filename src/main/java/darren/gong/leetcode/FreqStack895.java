package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class FreqStack895 {
  private Map<Integer, Integer> numToFreq = new HashMap<>();
  private Map<Integer, Stack<Integer>> freqToNumbers = new HashMap<>();
  private int maxFreq = 0;
  public FreqStack895() {
    freqToNumbers.put(0, new Stack<>());
  }

  public void push(int x) {
    Integer freq = numToFreq.getOrDefault(x, 0)+1;
    numToFreq.put(x, freq);
    freqToNumbers.putIfAbsent(freq, new Stack<>());
    freqToNumbers.get(freq).push(x);

    if (freq > maxFreq) {
      maxFreq = freq;
    }
  }

  public int pop() {
    if (maxFreq == 0) {
      return -1;
    }
    Stack<Integer> stack = freqToNumbers.get(maxFreq);
    int result = stack.pop();
    numToFreq.put(result, numToFreq.get(result)-1);
    if (stack.isEmpty()) {
      maxFreq--;
    }
    return result;
  }
}
