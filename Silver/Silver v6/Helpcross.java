import java.util.*;
import java.io.*;

public class Helpcross {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("helpcross.in")));
		PrintWriter out = new PrintWriter(new File("helpcross.out"));

		int n = nextInt();
		int m = nextInt();
		boolean[] used = new boolean[m];

		int[] chickens = new int[n];
		for (int i = 0; i < n; i++) chickens[i] = nextInt();

		Cow[] cows = new Cow[m];
		for (int i = 0; i < m; i++) cows[i] = new Cow(nextInt(), nextInt());

		Arrays.sort(chickens);
		Arrays.sort(cows);

		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < m; a++) {
				if (!used[a] && cows[a].start <= chickens[i] && chickens[i] <= cows[a].end) {
					ans++;
					used[a] = true;

					break;
				}
			}
		}

		out.println(ans);
		out.close();
	}

	static class Cow implements Comparable<Cow> {
		int start, end;

		Cow (int a, int b) {
			start = a;
			end = b;
		}

		public int compareTo (Cow other) {
			if (end == other.end) return Integer.compare(other.start, start);
			return Integer.compare(end, other.end);
		}
	}
}