// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: November 17, 2016
// Filename: Main.java
// Description: Serves as a UI for project presentation

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * This is the class we will use for our presentation of the project
 * It will call the methods of the individual problem files such as `Problem47.main()`
 */
public class GroupProject {
  public static void main(String[] args) {
    System.out.println("Hello there");
    //System.out.println(Problem1.sumOfNaturalNumbers(50));
  }
  /**
   * Solves problem at https://projecteuler.net/problem=1
   */
  public static int sumOfNaturalNumbers(int numLimit) {
    // Declare Variables
    int sumOfFactors = 0;
    
    // Search through all numbers within range
    for(int currentNum = 0; currentNum < numLimit; currentNum++) {
      // If it is a factor of 3 or 5, add it to the sum
      if(currentNum % 3 == 0 || currentNum % 5 == 0) {
        sumOfFactors += currentNum;
      }
    }
    return sumOfFactors;
  }
  /**
   * Solves problem at https://projecteuler.net/problem=6
   */
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
  /**
   * Solves problem at https://projecteuler.net/problem=16
   */
  public static void solveProblem16(String[] args) {
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
  /**
   * Solves problem at https://projecteuler.net/problem=17
   */
  public static void solveProblem17(String[] args) {
    // Declare variables
    long totalNumOfLetters;
    int[] numTestingRange = new int[2];
    Scanner keyboard = new Scanner(System.in);
    
    // Get range from user
    System.out.print("Enter the low range: ");
    numTestingRange[0] = keyboard.nextInt();
    System.out.print("Enter the high range: ");
    numTestingRange[1] = keyboard.nextInt();
    
    totalNumOfLetters = countLettersOfInterval(numTestingRange[0], numTestingRange[1]);
    
    System.out.printf("Letters it takes to print all the numbers from %d to %d: %d", 
                      numTestingRange[0], numTestingRange[1], totalNumOfLetters);
  }
  public static long countLettersOfInterval(int startingNumber, int endingNumber) {
    long totalNumOfLetters = 0;
    for (int numToTest = startingNumber; numToTest <= endingNumber; numToTest++) {
      totalNumOfLetters += toWords(numToTest).replaceAll(" ", "").length();
    }
    return totalNumOfLetters;
  }
  public static String toWords(long numToCompute) {
    // Declare Variables
    byte numOfDigits;
    
    Logger.getGlobal().setLevel(Level.OFF); 
    Logger.getGlobal().info("" + numToCompute);
    
    // Find out how many digits the number has
    for (numOfDigits = 1; numToCompute / Math.pow(10, numOfDigits - 1) >= 10; numOfDigits++);
    // Loop does nothing; it only updates `numOfDigits`
    
    // Read the number left-to-right
    String numberInWords = "";
    for (byte currentDigit = 1; currentDigit <= numOfDigits; currentDigit++) {
      String numberName = "";
      String numberNamePostfix = "";
      String numberNamePrefix = "";
      // Get number
      byte currentNumber = (byte) ((numToCompute / Math.pow(10, numOfDigits - currentDigit)) % 10);
      // Translate digit place to words, such as 'hundred' or 'thousand'
      //TODO: Make this work for higher places such as 'hundred thousand'
      byte nextNumber = numOfDigits - currentDigit > 0
        ? (byte) ((numToCompute / Math.pow(10, numOfDigits - currentDigit - 1)) % 10)
        : -1;
      if (numOfDigits >= 3 && (numOfDigits - currentDigit) == 1 && (currentNumber != 0 || nextNumber != 0)) {
        numberNamePrefix = "and";
      }
      switch ((numOfDigits - currentDigit) % 3) {
        case 1:
          switch (currentNumber) {
            case 1:
              switch (nextNumber) {
                case 0:
                  numberName = "ten";
                  break;
                case 1:
                  numberName = "eleven";
                  break;
                case 2:
                  numberName = "twelve";
                  break;
                case 3:
                  numberName = "thirteen";
                  break;
                case 4:
                  numberName = "fourteen";
                  break;
                case 5:
                  numberName = "fifthteen";
                  break;
                case 6:
                  numberName = "sixthteen";
                  break;
                case 7:
                  numberName = "seventhteen";
                  break;
                case 8:
                  numberName = "eightteen";
                  break;
                case 9:
                  numberName = "nineteen";
                  break;
                default:
              }
              // Since we looked ahead, we need to update the current digit accordingly
              currentDigit++;
              break;
            case 2:
              numberName = "twenty";
              break;
            case 3:
              numberName = "thirty";
              break;
            case 4:
              numberName = "fourty";
              break;
            case 5:
              numberName = "fifty";
              break;
            case 6:
              numberName = "sixty";
              break;
            case 7:
              numberName = "seventy";
              break;
            case 8:
              numberName = "eighty";
              break;
            case 9:
              numberName = "ninety";
              break;
            default:
              numberName = "";
          }
          break;
        case 2:
          numberNamePostfix = "hundred";
          // Fall through
        default:
          switch (currentNumber) {
            case 1:
              numberName = "one";
              break;
            case 2:
              numberName = "two";
              break;
            case 3:
              numberName = "three";
              break;
            case 4:
              numberName = "four";
              break;
            case 5:
              numberName = "five";
              break;
            case 6:
              numberName = "six";
              break;
            case 7:
              numberName = "seven";
              break;
            case 8:
              numberName = "eight";
              break;
            case 9:
              numberName = "nine";
              break;
            default:
              numberName = "";
          }
      }
      if ((numOfDigits - currentDigit) % 3 == 0) {
        switch ((numOfDigits - currentDigit) / 3) {
          case 1:
            numberNamePostfix += " thousand";
            break;
          case 2:
            numberNamePostfix += " million";
            break;
          case 3:
            numberNamePostfix += " billion";
            break;
          }
      }
      
      // Now that we have gathered the appriate words for the digit,
      // append to string
      if (!numberNamePrefix.equals("")) {
        numberInWords += " " + numberNamePrefix.trim();
      }
      if (!numberName.equals("")) {
        numberInWords += " " + numberName;
      }
      if (!numberNamePostfix.equals("")) {
        numberInWords += " " + numberNamePostfix.trim();
      }
    }
    numberInWords = numberInWords.trim();
    
    Logger.getGlobal().info(numberInWords);
    
    // Return result
    return numberInWords;
  }
  /**
   * Solves problem at https://projecteuler.net/problem=26
   */
  public static void solveProblem26(String[] args) {
    for (double d = 2; d < 10; d++) {
      int index = 0;
      double fraction = 1/d;
      String frac = Double.toString(fraction);
      String[] parts = new String[10];
      parts[index]= frac;
      System.out.println(parts[0]);
      index ++;
    }
  }
  /**
   * Solves problem at https://projecteuler.net/problem=47.
   * This program computes the first N positive integers to have M distinct factors each
   */
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
  /**
   * Solves problem at https://projecteuler.net/problem=124.
   * See Problem 47
   */
  public static void solveProblem47(String[] args) {
    ;
  }
  /**
   * Solves problem at https://projecteuler.net/problem=551.
   * See Problem 16
   */
  public static void solveProblem551(String[] args) {
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
