package darren.gong.leetcode;

public class Multiply43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        String result = "0";
        for (int i = length1-1; i >= 0; i--) {
            StringBuilder tempResult = new StringBuilder();
            for (int j = length1-1; j > i; j--) {
                tempResult.append('0');
            }
            int add = 0;
            int currentMultiply = num1Char[i] - '0';
            for (int j = length2-1; j >= 0 || add != 0; j--) {
                int multiplyOne = j >= 0 ? num2Char[j]-'0' : 0;
                int multiplyResult = currentMultiply * multiplyOne + add;
                tempResult.append(multiplyResult % 10);
                add = multiplyResult / 10;
            }
            result = add(result, tempResult.reverse().toString());
        }
        return result;
    }

    private String add(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = num1.length()-1, j = num2.length()-1; i >= 0 || j >= 0 || add != 0; i--, j--) {
            int addOne = i >= 0 ? num1Char[i]-'0' : 0;
            int addTwo = j >= 0 ? num2Char[j]-'0' : 0;
            int oneResult = addOne+addTwo+add;
            sb.append(oneResult%10);
            add = oneResult/10;
        }
        return sb.reverse().toString();
    }
}
