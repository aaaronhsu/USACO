import java.util.*;
import java.io.*;

public class Split {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("split.in")));
		PrintWriter out = new PrintWriter(new File("split.out"));

		int n = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(nextInt(), nextInt());
		}

		Arrays.sort(cows);

		int[] lmin = new int[n + 1];
		int[] lmax = new int[n + 1];
		int[] rmin = new int[n + 1];
		int[] rmax = new int[n + 1];

		lmin[0] = Integer.MAX_VALUE;
		rmin[n] = Integer.MAX_VALUE;

		for (int i = 1; i < n + 1; i++) {
			lmin[i] = Integer.min(lmin[i - 1], cows[i - 1].y);
			lmax[i] = Integer.max(lmax[i - 1], cows[i - 1].y);
		}

		for (int i = n - 1; i >= 0; i--) {
			rmin[i] = Integer.min(rmin[i + 1], cows[i].y);
			rmax[i] = Integer.max(rmax[i + 1], cows[i].y);
		}

		int one = (cows[n - 1].x - cows[0].x) * (lmax[n] - lmin[n]);
		int ans = one;

		for (int i = 1; i < n; i++) {
			if (cows[i - 1].x == cows[i].x) {
				if (lmax[i] >= rmin[i] || lmin[i] <= rmax[i]) continue;
			}

			int lhs = (cows[i - 1].x - cows[0].x) * (lmax[i] - lmin[i]);
			int rhs = (cows[n - 1].x - cows[i].x) * (rmax[i] - rmin[i]);


			System.out.println("Cow " + i + ": has area of " + (lhs + rhs));
			ans = Integer.min(lhs + rhs, ans);
		}

		System.out.println(Arrays.toString(lmin));
		System.out.println(Arrays.toString(lmax));

		
		System.out.println(Arrays.toString(rmin));
		System.out.println(Arrays.toString(rmax));

		System.out.println(one);
		out.println(one - ans);
		out.close();
	}

	static class Cow implements Comparable<Cow> {
		int x, y;

		Cow (int a, int b) {
			x = a;
			y = b;
		}

		public int compareTo(Cow other) {
			if (x == other.x) return Integer.compare(y, other.y);
			return Integer.compare(x, other.x);
		}
	}
}