import java.util.*;
import java.io.*;

public class Mountains {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("mountains.in")));
		PrintWriter out = new PrintWriter(new File("mountains.out"));

		int n = nextInt();
		Mountain[] mountains = new Mountain[n];

		for (int i = 0; i < n; i++) {
			mountains[i] = new Mountain(nextInt(), nextInt());
		}

		Arrays.sort(mountains);

		int ans = 0;
		int curMax = 0;
		for (int i = 0; i < n; i++) {
			if (mountains[i].rB > curMax) {
				ans++;
				curMax = mountains[i].rB;
			}
		}

		out.println(ans);
		out.close();
	}

	static class Mountain implements Comparable<Mountain> {
		int lB, rB;

		Mountain (int a, int b) {
			lB = a - b;
			rB = a + b;
		}

		public int compareTo(Mountain other) {
			if (lB == other.lB) return Integer.compare(other.rB, rB);
			return Integer.compare(lB, other.lB);
		}
	}
}