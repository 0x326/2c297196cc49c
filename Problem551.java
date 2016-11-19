// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: October 31, 2016
// Filename: Problem551.java
// Description: Solves problem at https://projecteuler.net/problem=551

// Note: See Problem 16
import java.math.BigInteger;
public class Problem551 {
  public static void main(String[] args) {
    System.out.println(computeSeries("31054319", (long) Math.pow(10, 6), (long) Math.pow(10, 15))
                         .toString());
  }
  public static BigInteger computeSeries(String initialTerm, long startingIndex, long endingIndex) {
    BigInteger seriesTerm = new BigInteger(initialTerm);
    for (long i = startingIndex; i <= endingIndex; i++) {
      Integer digitSum = new Integer(Problem16.sumOfDigits(seriesTerm));
      BigInteger digitSumAsBigInteger = new BigInteger(digitSum.toString());
      seriesTerm = seriesTerm.add(digitSumAsBigInteger);
    }
    return seriesTerm;
  }
}
