import java.util.*;
import java.io.*;

public class Hps {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("hps.in")));
		PrintWriter out = new PrintWriter(new File("hps.out"));

		int n = nextInt();

		int[] h = new int[n + 1];
		int[] p = new int[n + 1];
		int[] s = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			String hold = next();

			if (hold.equals("H")) p[i]++;
			else if (hold.equals("P")) s[i]++;
			else h[i]++;

			h[i] += h[i - 1];
			p[i] += p[i - 1];
			s[i] += s[i - 1];
		}

		int ans = 0;

		for (int i = 1; i < n + 1; i++) {
			ans = Integer.max(ans, h[i] + (p[n] - p[i]));
			ans = Integer.max(ans, h[i] + (s[n] - s[i]));

			ans = Integer.max(ans, p[i] + (h[n] - h[i]));
			ans = Integer.max(ans, p[i] + (s[n] - s[i]));

			ans = Integer.max(ans, s[i] + (h[n] - h[i]));
			ans = Integer.max(ans, s[i] + (p[n] - p[i]));
		}

		out.println(ans);
		out.close();
	}
}