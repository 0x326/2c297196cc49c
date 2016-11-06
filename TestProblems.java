import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TestProblems extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testProblem1() {
    if (Problem1.solveProblem(10) != 23)
      throw new Error();
    /* Replace values with another test case
    if (Problem1.solveProblem(10) != 23)
      throw new Error();
    */
  }
  public void testProblem6() {
    // And so on
    ;
  }
}
