// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Unique IDs (respectively): meyerjm, clemenbr, sheridnc, zhangt9, hur4
// Percent Contribution (respectively): 
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: December 9, 2016
// Filename: GroupProject.java
// Description: Submission of group assignment to solve Project Euler chanllenges

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * This is the class we will use for our presentation of the project
 */
public class GroupProject {
  static Scanner keyboardReader = new Scanner(System.in);
  
  /**
   * 
   */
  public static void main(String[] args) {
    Logger.getGlobal().setLevel(Level.OFF);
    // Display banner
    System.out.println("//===================\\");
    System.out.println("||                   ||");
    System.out.println("||    CSE PROJECT    ||");
    System.out.println("||  John, Bri, Noah  ||");
    System.out.println("||  Tianyu, Ranyang  ||");
    System.out.println("||                   ||");
    System.out.println("\\===================//");
    
    String problemChoice;
    boolean shouldQuit = false;
    do {
      System.out.println();
      System.out.println("==== MAIN MENU ====");
      // Ask user for the problem
      System.out.println("What problem do you want solved?");
      System.out.println("Options are: Problem 1, Problem 6, Problem 16, Problem 17, Problem 47, Problem 551, Question 6 on More Looping, Question 11 on More Looping, or Question 23 on More Looping.");
      System.out.println("Enter 'exit' to quit");
      System.out.print("> ");
      problemChoice = keyboardReader.next().toLowerCase().replaceAll(" ","");
      if (problemChoice.equals("exit")) {
        shouldQuit = true;
      }
      else if(problemChoice.equals("problem1")) {
        solveProblem1();
      }
      else if(problemChoice.equals("problem6")) {
        solveProblem6();
      }
      else if(problemChoice.equals("problem16")) {
        solveProblem16();
      }
      else if(problemChoice.equals("problem17")) {
        solveProblem17();
      }
      else if(problemChoice.equals("problem47")) {
        solveProblem47();
      }
      else if(problemChoice.equals("problem551")) {
        solveProblem551();
      }
      else if(problemChoice.equals("question6")) {
        solveQuestion6();
      }
      else if(problemChoice.equals("question11")) {
        solveQuestion11();
      }
      else if(problemChoice.equals("question23")) {
        solveQuestion23();
      }
      else {
        System.out.println("Input not recognized");
      }
    } while (!shouldQuit);
  }
  
  //// PROBLEM 1 ////
  
  /**
   * Solves problem at https://projecteuler.net/problem=1
   */
  public static void solveProblem1() {
    System.out.println("Enter a number to find the sum of its natural numbers");
    int numLimit = keyboardReader.nextInt();
    System.out.println(sumOfNaturalNumbers(numLimit));
  }
  
  /**
   * Finds the sum of natural numbers which are multiples of five or three on the interval [1, numLimit)
   * @param numLimit The endpoint to the interval
   * @return The sum of the numbers
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
  
  //// PROBLEM 6 ////
  
  /**
   * Solves problem at https://projecteuler.net/problem=6
   */
  public static void solveProblem6() {
    System.out.println("Enter a number to find the sum of the squares");
    int limit = keyboardReader.nextInt();
    System.out.println(differenceOperation(limit));
  }
  
  /**
   * Finds the difference between $\Sigma_{k=1}^{N} (k^2)$ and $(\Sigma_{k=1}^{N} (k))^2$
   * @param limit The value of N for the above summation
   * @return The numerical difference
   */
  public static int differenceOperation(int limit) {
    // Compute $\Sigma_{k=1}^{N} (k^2)$
    int sumOfSquares = 0;
    for (int num = 0; num <= limit; num++) {
      sumOfSquares += Math.pow(num, 2);
    }
    
    // Compute $(\Sigma_{k=1}^{N} (k))^2$
    int sumOfIntegers = 0;
    for (int num = 0; num <= limit; num++) {
      sumOfIntegers += num;
    }
    int squareOfSums = (int) (Math.pow(sumOfIntegers, 2));
    
    return squareOfSums - sumOfSquares; 
  }
  
  //// PROBLEM 16 ////
  
  /**
   * Solves problem at https://projecteuler.net/problem=16
   */
  public static void solveProblem16() {
    BigInteger num = new BigInteger("2");
    System.out.println("Enter a number to find the sum of digits for a large number");
    int userNum = keyboardReader.nextInt();
    num = num.pow(userNum);
    System.out.print(sumOfDigits(num));
  }
  
  /**
   * Computes the sum of digits for a large number
   * @param A BigInteger representation of the number whose digits are to be counted
   * @return The sum of the digits
   */
  public static int sumOfDigits(BigInteger num) {
    int sum = 0;
    int numberOfDigits;
    BigInteger constant = new BigInteger("10");
    
    // Find number of digits
    for(numberOfDigits=1; num.divide(constant.pow(numberOfDigits - 1)).compareTo(constant) >= 0; numberOfDigits++);
    // Add digits
    for(int i = 0; i < numberOfDigits; i++) {
      sum = sum + (num.mod(constant)).intValue();
      num = num.divide(constant);
    }
    
    return sum;
  }
  
  //// PROBLEM 17 ////
  
  /**
   * Determines the culumative number of letters needed to write every numeral 
   * within a certain range provided by the user. 
   * Solves problem at https://projecteuler.net/problem=17
   */
  public static void solveProblem17() {
    // Declare variables
    long totalNumOfLetters;
    int[] numTestingRange = new int[2];
    
    // Get range from user
    System.out.print("Enter the low range: ");
    numTestingRange[0] = keyboardReader.nextInt();
    System.out.print("Enter the high range: ");
    numTestingRange[1] = keyboardReader.nextInt();
    
    totalNumOfLetters = countLettersOfInterval(numTestingRange[0], numTestingRange[1]);
    
    System.out.printf("Letters it takes to print all the numbers from %d to %d: %d", 
                      numTestingRange[0], numTestingRange[1], totalNumOfLetters);
  }
  
  /**
   * Converts every integer in the given interval into numeral 
   * and counts the total number of letters written across all numerals
   * @param startingNumber The inclusive interval endpoint
   * @param endingNumber The inclusive interval endpoint
   * @return The number of letters written across all numbers
   */
  public static long countLettersOfInterval(int startingNumber, int endingNumber) {
    long totalNumOfLetters = 0;
    for (int numToTest = startingNumber; numToTest <= endingNumber; numToTest++) {
      totalNumOfLetters += toNumeral(numToTest).replaceAll(" ", "").length();
    }
    return totalNumOfLetters;
  }
  
  /**
   * Converts a given number into its numeral (American syntax)
   * @param numToCompute The number to convert
   * @return The String representation of the number in words
   */
  public static String toNumeral(long numToCompute) {
    // Declare Variables
    byte numOfDigits;
    
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
  
  //// PROBLEM 47 ////
  
  /**
   * Solves problem at https://projecteuler.net/problem=47.
   * This program computes the first N positive integers to have M distinct factors each
   */
  public static void solveProblem47() {
    // Declare variables
    int desiredNumberOfFactors = 3;
    System.out.println("How many consectutive numbers of factors?");
    int desiredNumberOfConsecutiveNumbers = keyboardReader.nextInt(); //TODO: Make this variables dependent on user input
    int[] consecutiveNumbers = new int[desiredNumberOfConsecutiveNumbers];
    int[][] factorsOfConsecutiveNumbers = new int[desiredNumberOfConsecutiveNumbers][desiredNumberOfFactors];
    int tallyOfConsecutiveIntegers = 0;
    
    // Begin testing the interval [1, infinity) for integers until we find enough consecutive numbers
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
  
  
  //// PROBLEM 551 ////
  
  /**
   * Solves problem at https://projecteuler.net/problem=551.
   * See Problem 16
   */
  public static void solveProblem551() {
    System.out.println(computeSeries("31054319", (long) Math.pow(10, 6), (long) Math.pow(10, 15))
                         .toString());
  }
  
  /**
   *
   */
  public static BigInteger computeSeries(String initialTerm, long startingIndex, long endingIndex) {
    BigInteger seriesTerm = new BigInteger(initialTerm);
    for (long i = startingIndex; i <= endingIndex; i++) {
      Integer digitSum = new Integer(sumOfDigits(seriesTerm));
      BigInteger digitSumAsBigInteger = new BigInteger(digitSum.toString());
      seriesTerm = seriesTerm.add(digitSumAsBigInteger);
    }
    return seriesTerm;
  }
  
  //// QUESTION 6 FROM MORE LOOPING PROBLEM SHEET ////
  
  /**
   * Prompts the user for an integer and 
   * prints all postive prime numbers less than the given value
   * Solves question 6 at https://drive.google.com/open?id=0B9AgP9SyhVCWS2pFSTVfSk0zWlE
   */
  public static void solveQuestion6() {
    int numberChoice;
    boolean prime = false;
    Scanner keyboardReader = new Scanner(System.in);
    
    // Get upper limit
    System.out.print("Enter a number between 1 and 2,147,483,647: ");
    numberChoice = keyboardReader.nextInt();
    
    // Check each number less than the limit
    for(int i = 2 ; i < numberChoice; i++) {
      if(isPrime(i)) {
        // Output the number
        System.out.print(i + " ");
      }
    }
  }
  
  /**
   * Determines whether a number is prime
   * @param number The number to check
   * @return {@code true} if it is prime; {@code false} otherwise
   */
  public static boolean isPrime(int number) {
    boolean isNumPrime = true;
    for(int i = 2; i < number; i++) {
      if(number % i == 0){
        isNumPrime = false;
      }
    }
    return isNumPrime;
  }
  
  //// QUESTION 11 FROM MORE LOOPING PROBLEM SHEET ////
  
  /**
   * Sells 100 tickets and prints the number of buyers
   * Solves question 11 at https://drive.google.com/open?id=0B9AgP9SyhVCWS2pFSTVfSk0zWlE
   */
  public static void solveQuestion11() {
    int numOfBuyers = sellTickets(100);
    System.out.println("Total Number of Buyers: " + numOfBuyers);
  }
  /** 
   * Simulates a the selling of cinema tickets at ticket booth. Method will not quit until all tickets have been sold. Additionally, one person cannot buy more than four tickets. After all tickets have been sold
   * @param numberOfTickets The number of tickets to buy
   * @return The number of buyers
   */
  public static int sellTickets(int numberOfTickets) {
    int desiredQuantity = 0;
    int buyers = 0;
    while(numberOfTickets > 0) {
      // Get number of tickets wanted by customer
      System.out.println("How many tickets would you like to purchase?");
      desiredQuantity = keyboardReader.nextInt(); 
      
      // Check to see if there are enough tickets for this purchase
      if(desiredQuantity > numberOfTickets) {
        System.out.print("There are only " + numberOfTickets + " tickets remaining. ");
      }
      // Check to see if purchase exceeds customers quota
      else if(desiredQuantity > 4) {
        System.out.print("You can only buy up to 4 tickets. ");
      }
      // Complete transaction
      else {
        numberOfTickets = numberOfTickets - desiredQuantity;
        System.out.println("Remaining Tickets: " + numberOfTickets);
        buyers++;
      }
    }
    return buyers;
  }
  
  //// QUESTION 23 FROM MORE LOOPING PROBLEM SHEET ////
  
  /**
   * Prints a number triangle of incremental terms. Prints sum of each row.
   * Solves question 23 at https://drive.google.com/open?id=0B9AgP9SyhVCWS2pFSTVfSk0zWlE
   */
  public static void solveQuestion23() {
    int userInput;
    System.out.print("How rows would you like to print? ");
    userInput = keyboardReader.nextInt();
    
    int[][] nums = new int[userInput][userInput];
    for (int rowIndex = 0; rowIndex < nums.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
        nums[rowIndex][columnIndex] = columnIndex + 1;
      }
    }
    for(int[] row : nums) {
      int sum = 0;
      for(int columnIndex = 0; columnIndex < row.length; columnIndex++) {
        if (row[columnIndex] == 0) {
          break;
        }
        sum += row[columnIndex];
        System.out.print(row[columnIndex]);
        if (columnIndex != row.length - 1 && row[columnIndex + 1] != 0) {
          System.out.print(" + ");
        }
      }
      System.out.println(" = " + sum);
    }
  }
}
