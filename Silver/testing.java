import java.io.*;
import java.util.*;

public class testing {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("blist.in"));
    PrintWriter output = new PrintWriter(new File("blist.out"));

    // Start code here
    int n = input.nextInt();

    int[][] cows = new int[n][3];

    for(int i = 0; i < n; i++) {
      for(int a = 0; a < 3; a++) {
        cows[i][a] = input.nextInt();
      }
    }

    int[] min = new int[n];
    int[] max = new int[n];

    for(int i = 0; i < n; i++) {
      min[i] = cows[i][0];
    }
    for(int i = 0; i < n; i++) {
      max[i] = cows[i][1];
    }

    Arrays.sort(min);
    Arrays.sort(max);

    int[] time = new int[max[n - 1] - min[0]];

    for(int i = 0; i < n; i++) {
      for(int a = cows[i][0] - min[0]; a < cows[i][1] - min[0]; a++) {
        time[a] += cows[i][2];
      }
    }

    Arrays.sort(time);

    output.println(time[max[n - 1] - min[0] - 1]);
    output.close(); // need to close to finish writing file

  }
}
