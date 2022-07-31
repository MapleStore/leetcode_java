package darren.gong.leetcode;

import java.util.Stack;

public class IsValid591 {
  public static void main(String[] args) {
    IsValid591 isValid591 = new IsValid591();
    isValid591.isValid("<A><A>/A></A></A>");
  }
  public boolean isValid(String code) {
    if (code == null || code.length() == 0) {
      return false;
    }
    int length = code.length();
    if (code.charAt(0) != '<' || code.charAt(length-1) != '>') {
      return false;
    }
    Stack<String> tags = new Stack<>();
    for (int i = 0; i < length; i++) {
      // 所有文本都必须包含在tag里, 到最后tag全部清除
      if (i != 0 && tags.isEmpty()) {
        return false;
      }
      if (code.charAt(i) == '<') {
        if (!tags.isEmpty() && code.charAt(i+1) == '!') {
          int closeIndex = code.indexOf("]]>", i+2);
          if (closeIndex == -1) {
            return false;
          }
          if (code.substring(i+2, closeIndex).indexOf("[CDATA[") != 0) {
            return false;
          }
          i = closeIndex;
        } else {
          int closeIndex;
          if (code.charAt(i+1) == '/') {
            closeIndex = code.indexOf(">", i+2);
            if (closeIndex == -1) {
              return false;
            }
            String tagName = code.substring(i+2, closeIndex);
            if (!tagNameValid(tagName)) {
              return false;
            }
            if (tags.isEmpty() || !tags.pop().equals(tagName)) {
              return false;
            }
          } else {
            closeIndex = code.indexOf(">", i+1);
            if (closeIndex == -1) {
              return false;
            }
            String tagName = code.substring(i+1, closeIndex);
            if (!tagNameValid(tagName)) {
              return false;
            }
            tags.push(tagName);
          }
          i = closeIndex;
        }
      }
    }
    return tags.isEmpty();
  }
  private boolean tagNameValid(String tagName) {
    if (tagName.length() < 1 || tagName.length() > 9)
      return false;
    for (int i = 0; i < tagName.length(); i++) {
      if (!Character.isUpperCase(tagName.charAt(i)))
        return false;
    }
    return true;
  }
}
