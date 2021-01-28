import java.util.*;
import java.io.*;

public class SubArraydiv {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("testing.in")));
		
		int n = nextInt();
		int x = nextInt();

		int[] arr = new int[n + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);

		int curVal = 0;
		int ans = 0;
		for (int i = 1; i < n + 1; i++) {
			arr[i] = nextInt() + arr[i - 1];

			int hold = Arrays.binarySearch(arr, x - arr[i]);

			if (hold >= 0) ans++;
		}

		System.out.println(ans);
	}
}