import java.util.*;
import java.io.*;

public class Sum3 {
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

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = nextInt();
		boolean out = false;

		for (int i = 0; i < n; i++) {
			for (int a = i + 1; a < n; a++) {
				for (int b = a + 1; b < n; b++) {
					if (arr[i] + arr[a] + arr[b] == k) {
						System.out.println((i + 1) + " " + (a + 1) + " " + (b + 1));
						out = true;
					}

					if (out) break;
				}
				if (out) break;
			}
			if (out) break;
		}

		if (!out) System.out.println("IMPOSSIBLE");
	}
}