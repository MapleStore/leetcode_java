package darren.gong.leetcode;

public class CheckValidString678 {
  public static void main(String[] args) {
    CheckValidString678 checkValidString678 = new CheckValidString678();
    checkValidString678.checkValidString("(*)))");
  }
  public boolean checkValidString(String s) {
    int lowBrackets = 0;
    int highBrackets = 0;
    for (char oneChar : s.toCharArray()) {
      if (oneChar == '(') {
        lowBrackets++;
        highBrackets++;
      } else if (oneChar == ')') {
        if (lowBrackets > 0) lowBrackets--;
        highBrackets--;
      } else {
        if (lowBrackets > 0) lowBrackets--;
        highBrackets++;
      }
      if (highBrackets < 0) {
        return false;
      }
    }
    if (lowBrackets > 0) {
      return false;
    }
    return true;
  }
}
