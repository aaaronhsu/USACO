import java.util.*;
import java.io.*;

public class Moocast {
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

		for (int i = 0; i < n; i++) cows[i] = new Cow(nextInt(), nextInt(), nextInt());

		LinkedList[] connections = new LinkedList[n];

		for (int i = 0; i < n; i++) {

			LinkedList<Integer> hold = new LinkedList<>();

			for (int a = 0; a < n; a++) {
				if (cows[i].canTransmit(cows[a])) {
					hold.add(a);
				}
			}

			connections[i] = hold;
		}

		boolean[] seen = new boolean[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				ans = Integer.max(ans, dfs(i, seen, connections));
				seen = new boolean[n];
			}
		}

		out.println(ans);
		out.close();

		

	}

	static int dfs(int index, boolean[] seen, LinkedList[] connections) {
		if (seen[index]) return 0;

		int hold = 1;
		seen[index] = true;

		for (int i : (LinkedList<Integer>) connections[index]) {
			hold += dfs(i, seen, connections);
		}

		return hold;
	}

	static class Cow {
		int x, y, p;

		Cow (int a, int b, int c) {
			x = a;
			y = b;
			p = c;
		}

		public boolean canTransmit(Cow other) {
			double xDist = Math.abs(x - other.x);
			double yDist = Math.abs(y - other.y);

			if (Math.pow(xDist, 2) + Math.pow(yDist, 2) <= Math.pow(p, 2)) return true;
			return false;
		}
	}
}