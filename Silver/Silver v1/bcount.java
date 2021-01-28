import java.util.*;
import java.io.*;

public class bcount {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("bcount.in"));
    PrintWriter output = new PrintWriter(new File("bcount.out"));

    // Start code here
    int n = input.nextInt();
    int q = input.nextInt();

    int[] c = new int[n + 1];
    int[] co = new int[n + 1];
    int[] cow = new int[n + 1];

    for(int i = 1; i < n + 1; i++) {
      int hold = input.nextInt();
      c[i] = c[i - 1];
      co[i] = co[i - 1];
      cow[i] = cow[i - 1];

      if(hold == 1) c[i]++;
      else if (hold == 2) co[i]++;
      else cow[i]++;
    }

    for(int i = 0; i < q; i++) {
      int l = input.nextInt();
      int h = input.nextInt();
      System.out.println(c[h]);
      output.println((c[h] - c[l - 1]) + " " + (co[h] - co[l - 1]) + " " + (cow[h] - cow[l - 1]));
    }

    output.close();

  }
}
