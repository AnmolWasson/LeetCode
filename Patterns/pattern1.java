import java.util.*;

public class pattern1 {

  public static void main(String args[]) {
    int n = 5;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // for any i if 0<=j&&j<n print star
        if (j >= 0 && j < n) {
          System.out.print("* ");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
