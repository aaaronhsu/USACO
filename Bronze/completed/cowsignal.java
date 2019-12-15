import java.util.*;
import java.io.*;

public class cowsignal {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("cowsignal.in"));
    PrintWriter output = new PrintWriter(new File("cowsignal.out"));

    // Start code here

    int m = input.nextInt();
    int n = input.nextInt();
    int k = input.nextInt();

    char[][] before = new char[m][n];
    String holder = null;

    for(int i = 0; i < m; i++) {
      holder = input.next();

      for(int a = 0; a < n; a++) {
        before[i][a] = holder.charAt(a);
      }
    }

    char[][] after = new char[m * k][n * k];
    int letterOffSet = 0;
    int lineOffSet = 0;

    for(int i = 0; i < m; i++) {

      for(int a = 0; a < n; a++) {
        for(int p = 0; p < k; p++) {
          after[lineOffSet][letterOffSet] = before[i][a];
          letterOffSet++;
        }
      }

      letterOffSet = 0;

      for(int p = 0; p < k; p++) {
        after[lineOffSet] = after[lineOffSet].clone();
        lineOffSet++;
      }
    }

    lineOffSet = 0;
    for(int i = 0; i < m * k; i += k) {
      for(int a = 0; a < k; a++) {
        after[i + lineOffSet] = after[i].clone();
        lineOffSet++;
      }
      lineOffSet = 0;
    }

    for(int i = 0; i < m * k; i++) {
      output.println(new String(after[i]));
    }
    output.close();

  }
}
