import java.util.*;
import java.io.*;

public class Pairup {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("pairup.in")));
		PrintWriter out = new PrintWriter(new File("pairup.out"));

		int n = nextInt();
		Cow[] cows = new Cow[n];
		int lhs = 0;
		int rhs = 0;
		for (int i = 0; i < n; i++) {
			int a = nextInt();
			int b = nextInt();
			rhs += b;

			cows[i] = new Cow(a, b);
		}
		Arrays.sort(cows);
		int ans = 0;

		int lhsI = 0;
		int rhsI = n - 1;

		while (lhsI < rhsI) {
			ans = Integer.max(ans, cows[rhsI].time + cows[lhsI].time);

			
		}

	}

	static class Cow implements Comparable<Cow> {
		int numCow, time;

		Cow (int a, int b) {
			numCow = a;
			time = b;
		}

		public int compareTo (Cow other) {
			return Integer.compare(time, other.time);
		}
	}
}