import java.util.*;
import java.io.*;

public class GoldMoocast {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("moocast.in")));
		PrintWriter out = new PrintWriter(new File("moocast.out"));

		int n = nextInt();
		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) cows[i] = new Cow(nextInt(), nextInt());

		int low = 0;
		int high = Integer.MAX_VALUE;

		while (high - low != 1) {
			int mid = (high + low) / 2;

			if (works(cows, mid)) high = mid;
			else low = mid;
		}

		if (works(cows, low)) out.println(low);
		else out.println(high);

		out.close();

		

	}

	static boolean works(Cow[] cows, int power) {
		if (dfs(0, cows, power, new boolean[cows.length]) == cows.length) return true;
		return false;
	}

	static int dfs(int index, Cow[] cows, int power, boolean[] seen) {
		if (seen[index]) return 0;

		seen[index] = true;
		int hold = 1;

		for (int i = 0; i < cows.length; i++) {
			if (cows[index].canTransmit(cows[i], power)) {
				hold += dfs(i, cows, power, seen);
			}
		}

		return hold;
	}

	static class Cow {
		int x, y;

		Cow (int a, int b) {
			x = a;
			y = b;
		}

		public boolean canTransmit(Cow other, int p) {
			double xDist = Math.abs(x - other.x);
			double yDist = Math.abs(y - other.y);

			if (Math.pow(xDist, 2) + Math.pow(yDist, 2) <= p) return true;
			return false;
		}
	}
}