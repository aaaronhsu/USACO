import java.util.*;
import java.io.*;

public class baseball {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("baseball.in"));
    PrintWriter output = new PrintWriter(new File("baseball.out"));

    // Start code here
    int n = input.nextInt();

    int[] cows = new int[n];

    for(int i = 0; i < n; i++) {
      cows[i] - input.nextInt();
    }

    Arrays.sort(cows);

    int low = (cows[cows.length - 1] - cows[0]) / 3;
    int high = (cows[cows.length - 1] - cows[0] - 1) / 2;

    int indexLow = high(cows, low);
    int indexHigh = low(cows, high);

    for(int i = indexLow; i < indexHigh; i++) {
      int nLow = cows[i]
    }
    // {1, 3, 4, 5, 6, 7, 10}
    // low = 3 (1) [5, 7]
    // high = 4 (2) []
    //
    // 2 - 1 + 1


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

O(n + logn)
