import java.util.*;
import java.io.*;

public class MaxSubarray {
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
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = nextInt();

		long maxSubarray = arr[0];
		long ans = arr[0];

		for (int i = 1; i < n; i++) {
			maxSubarray = Long.max(maxSubarray + arr[i], arr[i]);
			ans = Long.max(ans, maxSubarray);
		}

		System.out.println(ans);	
	}
}