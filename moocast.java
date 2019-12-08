import java.util.*;
import java.io.*;
import java.lang.Math;

public class moocast {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("moocast.in"));
    PrintWriter output = new PrintWriter(new File("moocast.out"));

    // Start code here
    int n = input.nextInt();
    int[][] cows = new int[n][3];

    for(int i = 0; i < n; i++) {
      cows[i][0] = input.nextInt();
      cows[i][1] = input.nextInt();
      cows[i][2] = input.nextInt();
    }

    int max = 0;
    int counter = 0;

    for(int i = 0; i < n; i++) {
      for(int a = 0; a < n; a++) {
        double dist = Math.sqrt(Math.pow(cows[i][1] - cows[i][0], 2) + Math.pow(cows[a][1] - cows[a][0], 2));
        if(dist <= cows[i][2]) {
          counter++;
        }
      }

      if(counter > max) {
        max = counter;
      }

      counter = 0;
    }

    output.write(Integer.toString(max));
    output.close();
  }
}
