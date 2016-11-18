// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: November 11, 2016
// Filename: Problem16.java
// Description: Solves problem at https://projecteuler.net/problem=16

import java.math.BigInteger;
public class Problem16 {
  public static void main(String[] args) {
    BigInteger num = new BigInteger("2");
    num = num.pow(1000);
    System.out.print(sumOfDigits(num));
  }
  public static int sumOfDigits(BigInteger num) {
    int sum = 0;
    int numberOfDigits;
    BigInteger constant = new BigInteger("10");
    for(numberOfDigits=1; num.divide(constant.pow(numberOfDigits - 1)).compareTo(constant) >= 0; numberOfDigits++);
    for(int i = 0; i < numberOfDigits; i++) {
      sum = sum + (num.mod(constant)).intValue();
      num = num.divide(constant);
    }
    return sum;
  }
}
