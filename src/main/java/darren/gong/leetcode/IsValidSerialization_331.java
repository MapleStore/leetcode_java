package darren.gong.leetcode;

public class IsValidSerialization_331 {
  // 331. 验证二叉树的前序序列化
  public static void main(String[] args) {
    IsValidSerialization_331 isValidSerialization_331 = new IsValidSerialization_331();
    isValidSerialization_331.isValidSerialization("9,#,#");
  }
  private int currentIndex = 0;
  public boolean isValidSerialization(String preorder) {
    String[] preorders = preorder.split(",");
    return isValidSerializationHelper(preorders) && currentIndex == preorders.length;
  }
  public boolean isValidSerializationHelper(String[] preorder) {
    if (currentIndex >= preorder.length) {
      return false;
    }
    if (preorder[currentIndex].equals("#")) {
      currentIndex++;
      return true;
    }
    currentIndex++;
    if (!isValidSerializationHelper(preorder)) {
      return false;
    }
    if (!isValidSerializationHelper(preorder)) {
      return false;
    }
    return true;
  }
}
