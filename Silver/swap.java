import java.util.*;
import java.io.*;

public class swap {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("swap.in"));
    PrintWriter output = new PrintWriter(new File("swap.out"));

    // Start code here
    int n = input.nextInt();
    int m = input.nextInt();
    int k = input.nextInt();

    int[][] swaps = new int[m][2];

    for (int i = 0; i < m; i++) {
        for (int a = 0; a < 2; a++) {
            swaps[i][a] = input.nextInt();
        }
    }

    int[] init = new int[n];
    for (int i = 0; i < init.length; i++) {
        init[i] = i + 1;
    }

    System.out.println(Arrays.toString(pattern(swaps, n)));

  }

  static int[] pattern(int[][] swaps, int n) {
    int[] holder = new int[n];
    for (int i = 0; i < holder.length; i++) {
        holder[i] = i + 1;
    }

    for (int i = 0; i < swaps.length; i++) {
      holder = swap(swaps[i][0] - 1, swaps[i][1] - 1, holder);
    }

    return holder;
  }

  static int[] swap(int start, int end, int[] arr) {
      int[] holder = new int[arr.length];
      int shift = 0;

      for (int i = 0; i < holder.length; i++) {
          if (i < start || i > end) holder[i] = arr[i];
          else {
              holder[i] = arr[end - shift];
              shift++;
          }
      }

      return holder;
  }
}
