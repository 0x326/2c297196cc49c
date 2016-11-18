// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: October 31, 2016
// Filename: Problem6.java
// Description: Solves problem at https://projecteuler.net/problem=6

public class Problem6 {
  public static void main(String[] args) {
    int sumOfSquares = 0;
    int squareOfSums = 0;
    int sumOfIntegers = 0;
    for (int num = 0; num <= 100; num++) {
      sumOfSquares += Math.pow(num, 2);
    }
    
    for (int num = 0; num <= 100; num++) {
      sumOfIntegers += num;
    }
    squareOfSums = (int)(Math.pow(sumOfIntegers, 2));
    
    System.out.println(squareOfSums - sumOfSquares); 
  }
}
