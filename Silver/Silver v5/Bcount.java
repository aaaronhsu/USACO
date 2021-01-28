import java.util.*;
import java.io.*;

public class Bcount {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("bcount.in")));
		PrintWriter out = new PrintWriter(new File("bcount.out"));

		int n = nextInt();
		int q = nextInt();

		int[] h = new int[n + 1];
		int[] g = new int[n + 1];
		int[] j = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			int hold = nextInt();

			if (hold == 1) h[i]++;
			else if (hold == 2) g[i]++;
			else j[i]++;

			h[i] += h[i - 1];
			g[i] += g[i - 1];
			j[i] += j[i - 1];
		}


		for (int i = 0; i < q; i++) {
			int start = nextInt();
			int end = nextInt();

			out.println((h[end] - h[start - 1]) + " " + (g[end] - g[start - 1]) + " " + (j[end] - j[start - 1]));
		}

		out.close();
	}
}