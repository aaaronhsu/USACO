import java.util.*;
import java.io.*;

public class Ferris {
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
		in = new StreamTokenizer(System.in);

		int n = nextInt();
		int k = nextInt();

		int[] children = new int[n];
		for (int i = 0; i < n; i++) children[i] = nextInt();

		Arrays.sort(children);

		int low = 0;
		int high = n - 1;

		int ans = 0;

		while (high >= low) {
			if (children[high] + children[low] <= k) {
				low++;
			}
			ans++;
			high--;
		}

		System.out.println(ans);
	}
}
