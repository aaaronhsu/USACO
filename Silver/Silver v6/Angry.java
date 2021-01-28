import java.util.*;
import java.io.*;

public class Angry {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception {
		in.nextToken();
		return (String) in.sval;
	}
	
	static long nextLong() throws Exception {
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("angry.in")));
		PrintWriter out = new PrintWriter(new File("angry.out"));

		int n = nextInt();
		int[] cows = new int[n];
		for (int i = 0; i < n; i++) cows[i] = nextInt();

		Arrays.sort(cows);
		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 1; i < n; i++) {
			if (cows[i] - cows[i - 1] > left[i - 1]) left[i] = cows[i] - cows[i - 1] + 1;
			else left[i] = left[i - 1] + 1;
		}

		for (int i = n - 2; i >= 0; i--) {
			if (cows[i + 1] - cows[i] > right[i + 1]) right[i] = cows[i + 1] - cows[i] + 1;
			else right[i] = right[i + 1] + 1;
		}
		
		double ans = Double.MAX_VALUE;

		for (int i = 1; i < n - 1; i++) {
			int a = Integer.max(left[i - 1], right[i]);
			int b = Integer.max(right[i - 1], left[i]);

			if (a < b) {
				double mid = ((double) (cows[i] - cows[i - 1])) / 2;

				if (a <= mid) {
					ans = Double.min(ans, mid);
				}
				else ans = Double.min(ans, a);
			}
			else {
				double mid = ((double) (cows[i] - cows[i - 1])) / 2;

				if (b <= mid) {
					ans = Double.min(ans, mid);
				}
				else ans = Double.min(ans, b);
			}
		}

		out.println(ans);
		out.close();
	}
}