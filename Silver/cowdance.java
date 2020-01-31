import java.util.*;
import java.io.*;

public class cowdance {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("cowdance.in"));
    PrintWriter output = new PrintWriter(new File("cowdance.out"));

    // Start code here

   int n = input.nextInt();
   int maxTime = input.nextInt();

   int[] cows = new int[n];
   for(int i = 0; i < n; i++) {
     cows[i] = input.nextInt();
   }

   int k = n;
   int high = k;
   int low = 1;

   while(high - low != 1) {
     k = (high + low) / 2;
     if(works(cows, k, maxTime)) {
       high = k;
     }
     else {
       low = k;
     }
   }

   if(works(cows, low, maxTime)) {
     output.println(low);
   }
   else {
     output.println(high);
   }

   output.close();
   input.close();


  }

  static boolean works(int[] cows, int k, int maxTime) {
    PriorityQueue<Integer> dancing = new PriorityQueue<>();

    int time = 0;

    for(int i = 0; i < cows.length; i++) {
      if(dancing.size() == k) {
        time = dancing.poll();
        if(time + cows[i] > maxTime) {
          return false;
        }
      }

      dancing.add(cows[i] + time);
    }

    return true;

  }

}
