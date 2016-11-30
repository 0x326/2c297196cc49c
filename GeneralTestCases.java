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
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testX() {
    ;
  }
  public void testProblem1() {
    if (GroupProject.sumOfNaturalNumbers(10) != 23)
      throw new Error();
    /* Replace values with another test case
    if (GroupProject.sumOfNaturalNumbers(10) != 23)
      throw new Error();
    */
  }
  public void testProblem6() {
    // And so on
    ;
  }
}
