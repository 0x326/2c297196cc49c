// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: October 31, 2016
// Filename: Problem17.java
// Description: Solves problem at https://projecteuler.net/problem=17

import java.util.logging.Logger;
import java.util.logging.Level;

public class Problem17 {
  public static void main(String[] args) {
    // Declare Variables
    long numToCompute = 5125426158L;
    byte numOfDigits;

    //Logger.getGlobal().setLevel(Level.OFF); // TODO: Uncoment this line for final submission
    Logger.getGlobal().info("" + numToCompute);

    // Find out how many digits the number has
    for (numOfDigits = 1; numToCompute / Math.pow(10, numOfDigits - 1) > 10; numOfDigits++) {
      // Do nothing
    }

    // Read the number left-to-right
    String numberInWords = "";
    for (byte currentDigit = 1; currentDigit <= numOfDigits; currentDigit++) {
      String numberName = "";
      String numberPlaceName = "";
      // Get number
      byte currentNumber = (byte) ((numToCompute / Math.pow(10, numOfDigits - currentDigit)) % 10);
      // Translate digit place to words, such as 'hundred' or 'thousand'
      //TODO: Make this work for higher places such as 'hundred thousand'
      switch ((numOfDigits - currentDigit) % 3) {
        case 1:
          switch (currentNumber) {
            case 1:
              byte nextNumber = numOfDigits - currentDigit > 0
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
          numberPlaceName = "hundred";
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
            numberPlaceName += " thousand";
            break;
          case 2:
            numberPlaceName += " million";
            break;
          case 3:
            numberPlaceName += " billion";
            break;
          }
      }
      // Append to string
      numberInWords += " " + numberName;
      if (!numberPlaceName.equals("")) {
        numberInWords += " " + numberPlaceName.trim();
      }
    }

    // Display result
    System.out.println(numberInWords);
  }
}
