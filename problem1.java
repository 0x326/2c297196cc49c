// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: October 31, 2016
// Filename: Problem1.java
// Description: Solves problem one at https://projecteuler.net/

public class Problem1 {
  public static void main(String[] args) {
    // Declare Variables
    int sumOfFactors = 0;
    int numLimit = 1000;
    
    // Search through all numbers within range
    for(int currentNum = 0; currentNum < numLimit; currentNum++) {
      // If it is a factor of 3 or 5, add it to the sum
      if(currentNum % 3 == 0 || currentNum % 5 == 0) {
        sumOfFactors += currentNum;
      }
    }
    System.out.println(sum);
  }
}
