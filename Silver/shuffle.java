import java.util.*;
import java.io.*;

public class shuffle {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("shuffle.in"));
    PrintWriter output = new PrintWriter(new File("shuffle.out"));

    // Start code here

    int n = input.nextInt();
    int[] cows = new int[n];

    for (int i = 0; i < n; i++) {
        cows[i] = input.nextInt() - 1;
    }

    // LinkedList<Integer>[] pos = new LinkedList[n];
    // for (int i = 0; i < n; i++) {
    //     pos[i] = new LinkedList<>();
    // }
    // for (int i = 0; i < n; i++) {
    //     pos[cows[i]].add(i);
    // }


    output.println(5);
    output.close();
  }
}
