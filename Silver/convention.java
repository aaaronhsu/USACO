import java.util.*;
import java.io.*;

public class convention {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("convention.in"));
    PrintWriter output = new PrintWriter(new File("convention.out"));

    // Start code here
    int cows = input.nextInt();
    int buses = input.nextInt();
    int size = input.nextInt();

    int[] times = new int[cows];

    for(int i = 0; i < cows; i++) {
      times[i] = input.nextInt();
    }

    Arrays.sort(times);



    int low = 0;
    int high = 1000000000;
		int middle = (high + low) / 2;

    while(high - low != 1) {
      middle = (high + low) / 2;

      if(check(cows, times, size, buses, middle)) high = middle;
      else low = middle;
    }


    output.println(high);
    output.close();

  }

  static boolean check(int cows, int[] times, int size, int buses, int VALUE) {
    int currentBuses = 1;
    int compareTo = 0;
    int capacity = 0;

    for(int i = 0; i < cows; i++) {
      if(times[i] - times[compareTo] > VALUE || capacity >= size) {
        currentBuses++;
        compareTo = i;
        capacity = 0;
        System.out.println(currentBuses);
      }

      capacity++;
    }

    if(currentBuses <= buses) return true;
    return false;
  }

}
