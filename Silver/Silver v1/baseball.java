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
      cows[i] = input.nextInt();
    }

    Arrays.sort(cows);

    int ans = 0;

   for(int i = 0; i < cows.length - 1; i++) {
     for(int a = i + 1; a < cows.length; a++) {
       int l = (2 * cows[a]) - cows[i];
       int h = 2 * (cows[a] - cows[i]) + cows[a];

       ans += low(cows, h) - high(cows, l) + 1;

     }
   }


    output.println(ans);
    output.close();
    input.close();
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
