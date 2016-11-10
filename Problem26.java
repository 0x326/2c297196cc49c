public class Problem26 {
  public static void main(String[] args) {
    for (double i = 2; i < 10; i++) {
      double fraction = i/2;
      String frac = Double.toString(fraction);
      String[] parts = frac.split(".");
      System.out.println(parts[1]);
    }
  }
}
