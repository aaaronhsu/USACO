import java.util.*;
import java.io.*;

public class bcount {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("bcount.in"));
    PrintWriter output = new PrintWriter(new File("bcount.out"));

    // Start code here
    int n = input.nextInt();
    int q = input.nextInt();

    int[] cows = new int[n];

    for(int i = 0; i < n; i++) {
      cows[i] = input.nextInt();
    }


    int[][] ans = new int[q][3];

    for(int i = 0; i < q; i++) {
      int t = input.nextInt();
      int p = input.nextInt();
      for(int a = t - 1; a <= p - 1; a++) {
        if(cows[a] == 1) {
          ans[i][0]++;
        }
        else if(cows[a] == 2) {
          ans[i][1]++;
        }
        else {
          ans[i][2]++;
        }
      }
    }

    for(int i = 0; i < q; i++) {
      output.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
    }

    output.close();

  }
}
