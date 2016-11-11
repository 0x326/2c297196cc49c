import java.util.logging.Logger;
import java.util.logging.Level;

public class Program47 {
  public static void main(String[] args) {
    //Logger.getGlobal().setLevel(Level.OFF); // TODO: Uncoment this line for final submission
    int desiredNum = 3;
    int[] desiredNumbers = new int[desiredNum]; // Numbers with the desired number of singled factors
    int[][] desiredNumbersFactorization = new int[desiredNum][50];
    int numOfConsecutiveIntegers = 0;
    for (int i = 1; numOfConsecutiveIntegers < desiredNum; i++) {
      Logger.getGlobal().info("i: " + i);
      int[] factorList = primeFactor(i);
      factorList = singleFactors(factorList);
      // If the singled factors is the length we want
      if (factorList.length == desiredNum) {
        // Store the number the factors represent
        desiredNumbers[numOfConsecutiveIntegers] = i;
        // Store its factors as well
        desiredNumbersFactorization[numOfConsecutiveIntegers] = factorList;
        numOfConsecutiveIntegers++;
      }
      else {
        numOfConsecutiveIntegers = 0;
        java.util.Arrays.fill(desiredNumbers, 0);
        desiredNumbersFactorization = new int[desiredNum][10];
      }
    }
    for (int numberIndex = 0; numberIndex < desiredNumbers.length; numberIndex++) {
      System.out.print(desiredNumbers[numberIndex] + " =");
      System.out.print(" " + desiredNumbersFactorization[numberIndex][0]);
      for (int factorIndex = 1; factorIndex < desiredNumbersFactorization[numberIndex].length; factorIndex++) {
        System.out.print(" X " + desiredNumbersFactorization[numberIndex][factorIndex]);
      }
      System.out.println();
    }
  }
  public static int[] primeFactor(long num) {
    if (num == 1) {
      return new int[] {1};
    }
    int factorsFound = 0;
    int[] factors = new int[10];
    do {
      for (int divisor = 2; divisor <= num; divisor++) {
        if (num % divisor == 0) {
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
  public static int[] singleFactors(int[] factorList) {
    int[] singledFactorList = new int[10];
    int numOfSingledFactors = 0;
    for (int factor : factorList) {
      java.util.Arrays.sort(singledFactorList);
      if (java.util.Arrays.binarySearch(singledFactorList, factor) < 0) {
        if (numOfSingledFactors == singledFactorList.length) {
          singledFactorList = java.util.Arrays.copyOf(singledFactorList, singledFactorList.length + 10);
        }
        singledFactorList[numOfSingledFactors++] = factor;
      }
    }
    singledFactorList = java.util.Arrays.copyOf(singledFactorList, numOfSingledFactors);
    return singledFactorList;
  }
}
