import java.util.*;
import java.io.*;

public class haybales {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("haybales.in"));
    PrintWriter output = new PrintWriter(new File("haybales.out"));

    // Start code here
    int n = input.nextInt();
    int q = input.nextInt();

    int[] arr = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    Arrays.sort(arr); // nlogn

    for(int i = 0; i < q; i++) {
      int t1 = input.nextInt();
      int t2 = input.nextInt();

      int lower = high(arr, t1);
      int upper = low(arr, t2);

      System.out.println(lower);
      System.out.println(upper);

      output.println(upper - lower + 1);
    }


    output.close();
  }

  static int low(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int middle = (high + low) / 2;

		while(low <= high) {
			middle = (high + low) / 2;

			if(arr[middle] == target) return middle;
			else if(arr[middle] < target) low = middle + 1;
			else high = middle - 1;
		}

		return high;
	}

  static int high(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int middle = (high + low) / 2;

		while(low <= high) {
			middle = (high + low) / 2;

			if(arr[middle] == target) return middle;
			else if(arr[middle] < target) low = middle + 1;
			else high = middle - 1;
		}

		return low;
	}
}
