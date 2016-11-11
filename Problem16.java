import java.math.BigInteger;
public class Problem16 {
   public static void main(String[] args) {
      BigInteger num = new BigInteger("2");
      num = num.pow(1000);
      int sum =0;
      int numberOfDigits;
      BigInteger constant = new BigInteger ("10");
      for(numberOfDigits=1; num.divide(constant.pow(numberOfDigits -1)).compareTo(constant) >= 0; numberOfDigits++);
      for(int i = 0; i < numberOfDigits; i++) {
         sum = sum + (num.mod(constant)).intValue();
         num = num.divide(constant);
      }
      System.out.print(sum);
   }
}