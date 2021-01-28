import java.util.*;
import java.io.*;

public class Cowjog {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("cowjog.in")));
		PrintWriter out = new PrintWriter(new File("cowjog.out"));

		long n = nextInt();
		long t = nextInt();

		long[] cows = new long[(int) n];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt() + nextInt() * t;
		}

		long ans = 1;
		long current = cows[(int) n - 1];
		for (int i = (int) n - 2; i >= 0; i--) {
			if (cows[i] < current) {
				ans++;
				current = cows[i];
			}
		}

		out.println(ans);
		out.close();
	}
}