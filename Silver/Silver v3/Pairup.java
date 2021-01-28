import java.util.*;
import java.io.*;

public class Pairup {
	static StreamTokenizer in;
	static int n;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("pairup.in")));
		PrintWriter out = new PrintWriter(new File("pairup.out"));

		int n = nextInt();

		int[][] cows = new int[n][2];

		for (int i = 0; i < n; i++) {
			cows[i][0] = nextInt();
			cows[i][1] = nextInt();
		}

		Arrays.sort(cows, Comparator.comparingInt(o -> o[1]));

		for (int i = 0; i < n; i++) {
			System.out.println(cows[i][1]);
		}

		int[] prefix = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			prefix[i] = prefix[i - 1] + cows[i - 1][0];
		}

		int[] suffix = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			suffix[i] = suffix[i - 1] + cows[n - i][0];
		}
		

		int ans = 0;

		for (int i = 0; i < n; i++) {
			int holder = high(suffix, prefix[i] + 1) - 1;
			if (cows[n - holder - 1][1] + cows[i][1] > ans) ans = cows[n - holder - 1][1] + cows[i][1];
		}

		out.println(ans);
		out.close();
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