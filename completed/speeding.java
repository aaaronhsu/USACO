import java.util.*;
import java.io.*;

// 10/10

public class speeding {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("speeding.in"));
    PrintWriter output = new PrintWriter(new File("speeding.out"));

    int[] road = new int[100];
    int[] speeding = new int[100];

    int n = input.nextInt();
    int m = input.nextInt();

    int[][] limits = new int[n][2];
    int[][] bessie = new int[m][2];

    for(int i = 0; i < n; i++) {
      limits[i][0] = input.nextInt();
      limits[i][1] = input.nextInt();
    }

    for(int i = 0; i < m; i++) {
      bessie[i][0] = input.nextInt();
      bessie[i][1] = input.nextInt();
    }

    int buffer = 0;

    // runs for the number of sections of road
    for(int i = 0; i < n; i++) {
      // assigns each large section of road to indexes in road
      for(int a = 0; a < limits[i][0]; a++, buffer++) {
        road[buffer] = limits[i][1];
      }
    }

    buffer = 0;

    for(int i = 0; i < m; i++) {
      // assigns each large section of road to indexes in road
      for(int a = 0; a < bessie[i][0]; a++, buffer++) {
        speeding[buffer] = bessie[i][1];
      }
    }

    int maxSpeed = 0;
    for(int i = 0; i < 100; i++) {
      if(speeding[i] > road[i] && speeding[i] - road[i] > maxSpeed) {
        maxSpeed = speeding[i] - road[i];
      }
    }

    output.write(Integer.toString(maxSpeed));
    output.close();
  }
}
