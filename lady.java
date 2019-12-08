import java.util.*;
import java.io.*;

public class lady {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("lady.in"));
    PrintWriter output = new PrintWriter(new File("lady.out"));

    // Start code here
    int trials = input.nextInt();

    for(int i = 0; i < trials; i++) {
      solve(input, output);
    }

    output.close();
  }

  public static void solve(Scanner input, PrintWriter output) {
    int xsHold = input.nextInt();
    int ysHold = input.nextInt();

    // shifting the top right coordinates so that the bottom left of the map can be at (0, 0)
    int x2 = input.nextInt() - xsHold;
    int y2 = input.nextInt() - ysHold;
    int x1 = 0;
    int y1 = 0;

    int[][] map = new int[x2][y2];

    int numRocky = input.nextInt();
    int numBerry = input.nextInt();

    // rx1 is the rocky x1 coordinate
    int rx1 = -1;
    int ry1 = -1;
    int rx2 = -1;
    int ry2 = -1;

    for(int i = 0; i < numRocky; i++) {
      // subracting the offset so that the map is at (0, 0)
      rx1 = input.nextInt() - xsHold;
      ry1 = input.nextInt() - ysHold;
      rx2 = input.nextInt() - xsHold;
      ry2 = input.nextInt() - ysHold;

      for(int a = rx1; a < rx2; a++) {
        for(int b = ry1; b < ry2; b++) {
          if(a >= 0 && b >= 0 && a <= rx2 - xsHold && b <= ry2 - ysHold) {
            map[a][b] += 1;
          }
        }
      }
    }

    // do the same thing for the berry areas

    int bx1 = -1;
    int by1 = -1;
    int bx2 = -1;
    int by2 = -1;

    for(int i = 0; i < numBerry; i++) {
      bx1 = input.nextInt() - xsHold;
      by1 = input.nextInt() - ysHold;
      bx2 = input.nextInt() - xsHold;
      by2 = input.nextInt() - ysHold;

      for(int a = bx1; a < bx2; a++) {
        for(int b = by1; b < by2; b++) {
          if(a >= 0 && b >= 0 && a < bx2 - xsHold && b < by2 - ysHold) {
            map[a][b] += 1;
          }
        }
      }
    }

    int counter = 0;

    // checking for all the values still at 0 bc then that means that they werent modified
    for(int i = 0; i < x2; i++) {
      for(int a = 0; a < y2; a++) {
        if(map[i][a] == 0) {
          counter++;
        }
      }
    }

    // print function for debugging
    for(int i = 0; i < x2; i++) {
      for(int a = 0; a < y2; a++) {
        System.out.print(map[i][a]);
      }
      System.out.println("");
    }


    output.println(Integer.toString(counter));

  }
}
