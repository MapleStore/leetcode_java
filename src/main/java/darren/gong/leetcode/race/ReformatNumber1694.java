package darren.gong.leetcode.race;

public class ReformatNumber1694 {
  public static void main(String[] args) {
    ReformatNumber1694 reformatNumber1694 = new ReformatNumber1694();
    reformatNumber1694.reformatNumber("--17-5 229 35-39475 ");
  }
  public String reformatNumber(String number) {
    if (number == null || number.isEmpty()) {
      return "";
    }
    StringBuilder temp = new StringBuilder();
    char[] numberArr = number.toCharArray();
    for (char oneChar : numberArr) {
      if (oneChar >= '0' && oneChar <= '9') {
        temp.append(oneChar);
      }
    }
    int length = temp.length();
    int index = 0;
    StringBuilder result = new StringBuilder();
    while (length - index > 4) {
      int end = index+3;
      result.append(temp.substring(index, end));
      result.append('-');
      index = end;
    }
    if (length-index == 4) {
      int end = index+2;
      result.append(temp.substring(index, end));
      result.append('-');
      result.append(temp.substring(end));
      return result.toString();
    }
    result.append(temp.substring(index));
    return result.toString();
  }
}
