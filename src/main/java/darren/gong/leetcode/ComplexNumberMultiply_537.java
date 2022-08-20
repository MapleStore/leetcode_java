package darren.gong.leetcode;

public class ComplexNumberMultiply_537 {
  public static void main(String[] args) {
    ComplexNumberMultiply_537 complexNumberMultiply_537 = new ComplexNumberMultiply_537();
    complexNumberMultiply_537.complexNumberMultiply("1+1i", "1+1i");
  }
  public String complexNumberMultiply(String num1, String num2) {
    String[] split1 = num1.split("\\+");
    String[] split2 = num2.split("\\+");

    int real1 = Integer.parseInt(split1[0]);
    int real2 = Integer.parseInt(split2[0]);

    int unReal1 = Integer.parseInt(split1[1].substring(0, split1[1].indexOf('i')));
    int unReal2 = Integer.parseInt(split2[1].substring(0, split2[1].indexOf('i')));

    int resultReal = real1*real2-unReal1*unReal2;
    int unReal = unReal1*real2+unReal2*real1;
    return resultReal+"+"+unReal+"i";
  }
}
