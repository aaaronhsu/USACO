import java.util.*;
import java.io.*;

public class Lifeguards {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("lifeguards.in")));
		PrintWriter out = new PrintWriter(new File("lifeguards.out"));

		int n = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(nextInt(), nextInt());
		}

		Arrays.sort(cows);

		System.out.println(Arrays.toString(cows));

		int[] prefix = new int[n + 1];
		int ans = Integer.MAX_VALUE;

		for (int i = 1; i < n + 1; i++) {
			prefix[i] = prefix[i - 1] + cows[i - 1].t;
		}

		for (int i = 0; i < n; i++) {
			int search = cows[i].e;

			int timeTaken = 0;

			int low = 0;
			int high = n - 1;

			while (high - low != 1) {
				int middle = (high - low) / 2;

				if (cows[middle].s < search) low = middle;
				else high = middle;
			}

			if (cows[high].s < search) {
				timeTaken += search - cows[high].s;
				timeTaken += prefix[high] - prefix[i + 1];
			}
			else {
				timeTaken += search - cows[low].s;
				timeTaken += prefix[low] - prefix[i + 1];
			}


			search = cows[i].s;
			low = 0;
			high = n - 1;

			while (high - low != 1) {
				int middle = (high + low) / 2;

				if (cows[middle].e > search) low = middle;
				else high = middle;
			}

			if (cows[low].e > search) {
				timeTaken += cows[low].e - search;
				timeTaken += prefix[i] - prefix[low + 1];
			}
			else {
				timeTaken += cows[high].e - search;
				timeTaken += prefix[i] - prefix[high + 1];
			}

			ans = Integer.min(ans, timeTaken);
		}

		out.println(ans);
		out.close();
	}

	static class Cow implements Comparable<Cow> {
		int s, e, t;

		Cow(int s, int e) {
			this.s = s;
			this.e = e;
			this.t = e - s + 1;
		}

		public int compareTo(Cow other) {
			if (this.s == other.s) return Integer.compare(this.e, other.e);
			return Integer.compare(this.s, other.s);
		}

		public String toString() {
			return s + ", " + e + " with time " + t;
		}
	}
}