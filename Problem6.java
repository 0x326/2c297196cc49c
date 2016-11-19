// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: October 31, 2016
// Filename: Problem6.java
// Description: Solves problem at https://projecteuler.net/problem=6

public class Problem6 {
  public static void main(String[] args) {
    System.out.println(differenceOperation(100));
  }
  public static int differenceOperation(int limit) {
    int sumOfSquares = 0;
    for (int num = 0; num <= limit; num++) {
      sumOfSquares += Math.pow(num, 2);
    }
    
    int sumOfIntegers = 0;
    for (int num = 0; num <= limit; num++) {
      sumOfIntegers += num;
    }
    int squareOfSums = (int)(Math.pow(sumOfIntegers, 2));
    
    return squareOfSums - sumOfSquares; 
  }
}
