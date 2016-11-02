// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: October 31, 2016
// Filename: Problem17.java
// Description: Solves problem at https://projecteuler.net/problem=17

public class Problem17 {
  public static void main(String[] args) {
    // Declare Variables
    long numToCompute = 5125426158L;
    byte numOfDigits;
    
    // Find out how many digits the number has
    for (numOfDigits = 1; numToCompute / Math.pow(10, numOfDigits - 1) > 10; numOfDigits++) {
      // Do nothing
    }
    
    // Read the number left-to-right
    byte currentNumber;
    byte nextNumber;
    String numberName;
    String numberPlaceName;
    String numberInWords = "";
    for (byte currentDigit = 1; currentDigit <= numOfDigits; currentDigit++) {
      // Translate digit place to words, such as 'hundred' or 'thousand'
      //TODO: Make this work for higher places such as 'hundred thousand'
      switch (currentDigit) {
        case 3:
          numberPlaceName = "hundred";
          break;
        default:
          numberPlaceName = "";
      }
      // Get number
      currentNumber = (byte) ((numToCompute / Math.pow(10, numOfDigits - currentDigit)) % 10);
      // Translate into numeric word
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
      // Since a number sequence starting with `1` may have an irregular name, such as `12`
      // Peek at the next number
      if (currentDigit % 3 == 1 && currentNumber == 1) {
        nextNumber = numOfDigits - currentDigit > 0 
          ? (byte) ((numToCompute / Math.pow(10, numOfDigits - currentDigit - 1)) % 10)
          : -1;
        switch (nextNumber) {
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
            break;
        }
        // Since we looked ahead, we need to update the current digit accordingly
        currentDigit++;
      }
      // Append to string
      numberInWords += " " + numberName;
      if (!numberPlaceName.equals("")) {
        numberInWords += " " + numberPlaceName;
      }
    }
    
    // Display result
    System.out.println(numberInWords);
  }
}
