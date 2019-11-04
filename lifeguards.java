import java.util.*;
import java.io.*;

public class lifeguards {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("lifeguards.in"));
    PrintWriter output = new PrintWriter(new File("lifeguards.out"));

    // Start code here

    int numCows = input.nextInt();

    int[][] lifeguard = new int[numCows][2];

    for(int i = 0; i < numCows; i++) {
      lifeguard[i][0] = input.nextInt();
      lifeguard[i][1] = input.nextInt();
    }

    int[] shifts = new int[1000];

    for(int i = 0; i < numCows; i++) {
      for(int a = lifeguard[i][0]; a < lifeguard[i][1]; a++) {
        shifts[a - 1]++;
      }
    }

    int[] temp = shifts.clone();
    int[] remainingShifts = new int[numCows];
    int sum = 0;

    for(int a = 0; a < numCows; a++) {
      for(int i = lifeguard[a][0]; i < lifeguard[a][1]; i++) {
        temp[i - 1]--;
      }

      for(int b = 0; b < temp.length; b++) {
        if(temp[b] > 0) {
          sum++;
        }
      }
      
      remainingShifts[a] = sum;
      sum = 0;
      temp = shifts.clone();

    }

    Arrays.sort(remainingShifts);
    int highest = remainingShifts[remainingShifts.length - 1];

    output.write(Integer.toString(highest));
    output.close();

  }
}
