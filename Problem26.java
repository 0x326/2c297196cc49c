// Name: John Meyer, Bri Clements, Noah Sheridan, Tianyu Zhang, Ranyang Hu
// Instructor: Vijayalakshmi Ramasamy
// CSE 174, Section A
// Date: November 11, 2016
// Filename: Problem26.java
// Description: Solves problem at https://projecteuler.net/problem=26

public class Problem26 {
  public static void main(String[] args) {
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
}
