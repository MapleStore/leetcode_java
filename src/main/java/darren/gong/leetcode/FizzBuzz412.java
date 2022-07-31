package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz412 {
    public static void main(String[] args) {
        //fizzBuzz(1);
    }
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        String[] resultArr = new String[n];
        List<String> result = new ArrayList<>(n);
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";
        for (int i = 2; i < n; i += 3) {
            resultArr[i] = fizz;
        }
        for (int i = 4; i < n; i += 5) {
            if (resultArr[i] != null) {
                resultArr[i] = fizzBuzz;
            } else {
                resultArr[i] = buzz;
            }
        }
        for (int i = 0; i < n; i++) {
            if (resultArr[i] == null) {
                resultArr[i] = String.valueOf(i+1);
            }
        }
        return Arrays.asList(resultArr);
    }
}
