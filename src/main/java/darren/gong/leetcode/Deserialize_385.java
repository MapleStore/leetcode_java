package darren.gong.leetcode;

import java.util.List;

public class Deserialize_385 {
  // 385. 迷你语法分析器
  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  private class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger(){};

    // Constructor initializes a single integer.
    public NestedInteger(int value){};

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return true;};

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return -1;};

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){};

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){return null;};
  }
  public static void main(String[] args) {
    Deserialize_385 deserialize_385 = new Deserialize_385();
    deserialize_385.deserialize("[123,[456,[789]]]");
  }
  private int index = 0;
  public NestedInteger deserialize(String s) {
    NestedInteger nestedInteger = new NestedInteger();
    if (s.charAt(0) != '[') {
      nestedInteger.setInteger(Integer.valueOf(s));
      return nestedInteger;
    }
    index++;
    return deserializeHelper(s);
  }

  public NestedInteger deserializeHelper(String s) {
    NestedInteger nestedInteger = new NestedInteger();
    StringBuilder sb = new StringBuilder();
    while (index < s.length()) {
      char current = s.charAt(index);
      if (current == '[') {
        index++;
        nestedInteger.add(deserializeHelper(s));
      } else if (current == ',') {
        index++;
      } else if (current == ']') {
        index++;
        return nestedInteger;
      } else {
        sb.append(current);
        char next = s.charAt(index+1);
        if (next == '[' || next == ',' || next == ']') {
          nestedInteger.add(new NestedInteger(Integer.valueOf(sb.toString())));
          sb = new StringBuilder();
        }
        index++;
      }
    }
    return null;
  }
}
