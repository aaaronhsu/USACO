import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class angry {
	static StreamTokenizer in;

	static int cows;
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("angry.in")));
		PrintWriter out = new PrintWriter(new File("angry.out"));

		int n = nextInt();
		cows = nextInt();

		int[] bales = new int[n];

		for (int i = 0; i < n; i++) {
			bales[i] = nextInt();
		}

		Arrays.sort(bales);
		System.out.println(bales);
		
		int low = 0;
		int high = 1000000000;
		
		while (high - low != 1) {
			int mid = (high + low) / 2;

			if (works(mid, (int[]) bales.clone())) high = mid;
			else low = mid;

		}

		out.println(high);
		out.close();

		int[] tester = {1, 2, 5, 8, 14, 16};
		System.out.println(high(tester, 13));
	}

	static boolean works(int rad, int[] bales) {
		int holder = 0;
		for (int i = 0; i < cows; i++) {
			if (holder >= bales.length) return true;
			int range = 2 * rad + bales[holder];

			holder = high(bales, range);
			System.out.println(holder);
		}

		if (holder >= bales.length) return true;
		return false;
	}

	static int high(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return middle;
			else if (arr[middle] > target) high = middle;
			else low = middle;
		}

		if (arr[low] == target) return low;
		else return high;
	} 
}