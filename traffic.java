import java.util.*;
import java.io.*;

public class traffic {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("traffic.in"));
    PrintWriter output = new PrintWriter(new File("traffic.out"));

    // Start code here
    int n = input.nextInt();

    int[][] road = new int[n][3];
    String type = null;
    boolean convert = true;

    // data input
    for(int i = 0; i < n; i++) {
      for(int a = 0; a < 3; a++) {

        if(convert) {
          type = input.next();

          if(type.equals("none")) {
            road[i][a] = -1;
          }
          else if(type.equals("on")) {
            road[i][a] = -2;
          }
          else if(type.equals("off")) {
            road[i][a] = -3;
          }
          convert = false;
        }
        else {
          road[i][a] = input.nextInt();
        }
      }
      convert = true;
    }


    int nOne = -1;
    int nTwo = -1;

    int min = -1;
    int max = -1;
    boolean first = true;
    int fNone = 0;
    int lNone = 0;

    for(int i = 0; i < n; i++) {
      if(road[i][0] == -1) {
        if(first) {
          fNone = i;
          min = road[i][1];
          max = road[i][2];
          first = false;
        }
        // start bs
        else {
          if(road[i][1] < min) {
            road[i][1] = min;
          }

          if(road[i][2] > max) {
            road[i][2] = max;
          }

          min = road[i][1];
          max = road[i][2];
          lNone = i;
        }
      }
      else {
        if(road[i][0] == -2) {
          min += road[i][1];
          max += road[i][2];
        }
        else {
          min -= road[i][2];
          max -= road[i][1];
        }
      }
    }

    road[fNone][1] = road[lNone][1];
    road[fNone][2] = road[lNone][2];

    for(int i = fNone - 1; i >= 0; i--) {
      if(road[i][0] == -2) {
        road[fNone][1] -= road[i][2];
        road[fNone][2] -= road[i][1];
      }
      else {
        road[fNone][1] += road[i][1];
        road[fNone][2] += road[i][2];
      }
    }

    for(int i = lNone + 1; i < n; i++) {
      if(road[i][0] == -2) {
        road[lNone][1] += road[i][1];
        road[lNone][2] += road[i][2];
      }
      else {
        road[lNone][1] -= road[i][2];
        road[lNone][2] -= road[i][1];
      }
    }

    output.write(road[fNone][1] + " " + road[fNone][2]);
    output.println("");
    output.write(road[lNone][1] + " " + road[lNone][2]);
    output.close();
  }
}
