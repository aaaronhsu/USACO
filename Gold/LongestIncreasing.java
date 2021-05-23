import java.util.*;
import java.io.*;

public class LongestIncreasing {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("input.in")));

		int n = nextInt();
		int[] seq = new int[n];
		for (int i = 0; i < n; i++) seq[i] = nextInt();

		int[] ans = new int[n];

		int curMax = -1;
		for (int i = 1; i < n; i++) {

			int update = 0;

			for (int a = 0; a < i; a++) {
				if (seq[i] >= seq[a]) update = Integer.max(ans[a], update);
			}
			curMax = Integer.max(curMax, update + 1);
		}

		System.out.println(curMax);
	}
}