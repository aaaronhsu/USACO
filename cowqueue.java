import java.util.*;
import java.io.*;

public class cowqueue {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("cowqueue.in"));
    PrintWriter output = new PrintWriter(new File("cowqueue.out"));

    // Start code here
    int[] cows = new int[100000000];
    List<Integer> ends = new ArrayList<Integer>();

    int n = input.nextInt();

    for(int i = 0; i < n; i++) {
      int beginning = input.nextInt() - 1;
      int end = beginning + input.nextInt();
      ends.add(end);
      for(int a = beginning; a < end; a++) {
        cows[a]++;
      }
    }

    int highest = -1;
    for(int a : ends) {
      if(highest < a) {
        highest = a;
      }
    }

    for(int i = 0; i < highest; i++) {
      if(cows[i] == 0) {
        cows[i] = 1;
      }
    }

    int total = 0;
    for(int i = 0; i < highest; i++) {
      total += cows[i];
    }

    for(int i = 0; i < highest; i++) {
      System.out.println(cows[i]);
    }
    output.write(Integer.toString(total + 1));
    output.close();
  }
}
