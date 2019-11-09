import java.util.*;
import java.io.*;
// 10/10
public class blist {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(new File("blist.in"));
    PrintWriter output = new PrintWriter(new File("blist.out"));

    // Start code here
    int cows = input.nextInt();
    int[][] milked = new int[cows][3];

    for(int i = 0; i < cows; i++) {
      for(int a = 0; a < 3; a++) {
        milked[i][a] = input.nextInt();
      }
    }

    int[] time = new int[cows];
    for(int i = 0; i < cows; i++) {
      time[i] = milked[i][1];
    }

    Arrays.sort(time);

    int[] buckets = new int[time[time.length - 1]];

    for(int i = 0; i < cows; i++) {
      for(int a = 0; a < buckets.length; a++) {
        if(a >= milked[i][0] && a <= milked[i][1]) {
          buckets[a] += milked[i][2];
        }
      }
      System.out.println(Arrays.toString(buckets));
    }

    Arrays.sort(buckets);

    output.write(Integer.toString(buckets[buckets.length - 1]));
    output.close();
  }
}
