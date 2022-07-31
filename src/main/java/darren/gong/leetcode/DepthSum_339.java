package darren.gong.leetcode;

import java.util.List;

public class DepthSum_339 {
  // 339. 嵌套列表权重和
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

  public int depthSum(List<NestedInteger> nestedList) {
    int result = 0;
    for (NestedInteger nestedInteger : nestedList) {
      result += depthSum(nestedInteger, 1);
    }
    return result;
  }

  private int depthSum(NestedInteger nestedInteger, int deep) {
    if (nestedInteger.isInteger()) {
      return deep*nestedInteger.getInteger();
    }
    int result = 0;
    for (NestedInteger tempNestedInteger : nestedInteger.getList()) {
      result += depthSum(tempNestedInteger, deep+1);
    }
    return result;
  }
}
