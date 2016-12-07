// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: November 19, 2016
// Filename: GeneralTestCases.java
// Description: Tests the our solutions for correct answers

import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class GeneralTestCases extends TestCase {
  
  public void testProblem1() {
    if (GroupProject.sumOfNaturalNumbers(10) != 23)
      throw new Error();
    /* Replace values with another test case
    if (GroupProject.sumOfNaturalNumbers(10) != 23)
      throw new Error();
    */
  }
  /*public void testProblem6() {
    // And so on
    ;
  }*/
  public void testProblem17() {
    String[] numerals = {
      "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
      "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", 
      "nineteen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety",
      "one hundred one", "one hundred two", "one hundred ten", "one hundred eleven",
      "one hundred twelve", "one hundred thirteen", "one hundred twenty", "one hundred thirty one",
      "one hundred ninety nine", "two hundred", "two hundred one", "two hundred eleven",
      "nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred seven"
    };
    long[] numbers = {
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
      11, 12, 13, 14, 15, 16, 17, 18,
      19, 20, 30, 40, 50, 60, 70, 80, 90,
      101, 102, 110, 111, 
      112, 113, 120, 131,
      199, 200, 201, 211,
      9223372036854775807L
    };
    if (numerals.length != numbers.length) {
      throw new Error("Uneven number of test cases");
    }
    for (int testIndex = 0; testIndex < numerals.length; testIndex++) {
      String codeOutput = GroupProject.toNumeral(numbers[testIndex], false);
      if (!codeOutput.equals(numerals[testIndex])) {
        // Compile error message
        String errorMessage = ".toNumeral(" + numbers[testIndex] + ") returns `" + codeOutput
          + "` instead of expected `" + numerals[testIndex] + "`";
        throw new Error(errorMessage);
      }
    }
  }
}
