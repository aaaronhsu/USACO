import java.util.*;
import java.io.*;
// 10/10 correct: 25 minutes
public class gymnastics {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("gymnastics.in"));
    PrintWriter output = new PrintWriter(new File("gymnastics.out"));

    // Start code here
    int rounds = input.nextInt();
    int cows = input.nextInt();

    int consistentPairs = 0;

    int[][] places = new int[cows][rounds];

    for(int i = 0; i < rounds; i++) {
      for(int a = 0; a < cows; a++) {
        places[input.nextInt() - 1][i] = a;
      }
    }

    boolean passed = true;

    for(int cow = 0; cow < cows; cow++) {
      for(int compare = 0; compare < cows; compare++) {
        for(int round = 0; round < rounds; round++) {
          if(places[cow][round] >= places[compare][round]) {
            passed = false;
          }
        }

        if(passed) {
          consistentPairs++;
        }

        passed = true;
      }
    }

    output.println(Integer.toString(consistentPairs));
    output.close();
  }
}
