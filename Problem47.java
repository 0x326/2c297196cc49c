// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: November 11, 2016
// Filename: Problem47.java
// Description: Solves problem at https://projecteuler.net/problem=47

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * This program computes the first N positive integers to have M distinct factors each
 */
public class Program47 {
  public static void main(String[] args) {
    Logger.getGlobal().setLevel(Level.OFF);
    // Declare variables
    int desiredNumberOfFactors = 3;
    int desiredNumberOfConsecutiveNumbers = 3;
    int[] consecutiveNumbers = new int[desiredNumberOfConsecutiveNumbers];
    int[][] factorsOfConsecutiveNumbers = new int[desiredNumberOfConsecutiveNumbers][desiredNumberOfFactors];
    int tallyOfConsecutiveIntegers = 0;
    
    // Begin testing the interval [1, ?) for integers until we find enough consecutive numbers
    for (int i = 1; tallyOfConsecutiveIntegers < desiredNumberOfConsecutiveNumbers; i++) {
      Logger.getGlobal().info("i: " + i);
      // Factor the integer
      int[] factorList = primeFactor(i);
      // Filter distinct factors
      factorList = filterToDistinctFactors(factorList);
      // If the distinct factors is the length we want
      if (factorList.length == desiredNumberOfFactors) {
        // Store the number the factors represent
        consecutiveNumbers[tallyOfConsecutiveIntegers] = i;
        // Store its factors as well
        if (factorList.length > factorsOfConsecutiveNumbers[tallyOfConsecutiveIntegers].length) {
          factorsOfConsecutiveNumbers[tallyOfConsecutiveIntegers] = new int[factorList.length];
        }
        factorsOfConsecutiveNumbers[tallyOfConsecutiveIntegers] = factorList;
        tallyOfConsecutiveIntegers++;
      }
      else {
        tallyOfConsecutiveIntegers = 0;
        java.util.Arrays.fill(consecutiveNumbers, 0);
        factorsOfConsecutiveNumbers = new int[desiredNumberOfConsecutiveNumbers][desiredNumberOfFactors];
      }
    }
    // Print consecutive numbers and their factors
    for (int numberIndex = 0; numberIndex < consecutiveNumbers.length; numberIndex++) {
      System.out.print(consecutiveNumbers[numberIndex] + " =");
      // Cycle through factors
      System.out.print(" " + factorsOfConsecutiveNumbers[numberIndex][0]);
      for (int factorIndex = 1; factorIndex < factorsOfConsecutiveNumbers[numberIndex].length; factorIndex++) {
        System.out.print(" X " + factorsOfConsecutiveNumbers[numberIndex][factorIndex]);
      }
      System.out.println();
    }
  }
  /**
   * Computes the prime factors of the given argument
   * @param num The number to prime factorize
   * @return An int array of its factors. Returns {1} if {@code num == 1}
   */
  public static int[] primeFactor(long num) {
    if (num == 1) {
      return new int[] {1};
    }
    int factorsFound = 0;
    int[] factors = new int[10];
    do {
      for (int divisor = 2; divisor <= num; divisor++) {
        if (num % divisor == 0) {
          // Expand array of factors if needed
          if (factorsFound == factors.length) {
            factors = java.util.Arrays.copyOf(factors, factors.length + 10);
          }
          factors[factorsFound++] = divisor;
          num /= divisor;
          break;
        }
      }
    } while (num != 1);
    factors = java.util.Arrays.copyOf(factors, factorsFound);
    return factors;
  }
  /**
   * Filters an array of factors into an array of distinct factors
   * @param factorList The int array of factors
   * @return An array of distinct factors found among {@code factorList}
   */
  public static int[] filterToDistinctFactors(int[] factorList) {
    int[] distinctFactors = new int[factorList.length];
    int numOfDistinctFactors = 0;
    for (int factor : factorList) {
      java.util.Arrays.sort(distinctFactors);
      // If `factor` is not already counted in `distinctFactors`,
      // Then add it to `distinctFactors`
      if (java.util.Arrays.binarySearch(distinctFactors, factor) < 0) {
        distinctFactors[0] = factor;
        numOfDistinctFactors++;
      }
    }
    java.util.Arrays.sort(distinctFactors);
    if (numOfDistinctFactors > 0) {
      distinctFactors = java.util.Arrays.copyOfRange(distinctFactors, 
                                                     distinctFactors.length - numOfDistinctFactors, 
                                                     distinctFactors.length);
    }
    else {
      distinctFactors = new int[0];
    }
    return distinctFactors;
  }
}
