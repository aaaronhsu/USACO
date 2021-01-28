import java.util.*;
import java.io.*;

public class Fenceplan {
	static StreamTokenizer in;
	static int n, m;

	static boolean[] seen;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("fenceplan.in")));
		PrintWriter out = new PrintWriter(new File("fenceplan.out"));

		n = nextInt();
		m = nextInt();

		Cow[] cows = new Cow[n];
		Bounds[] bounds = new Bounds[n];
		seen = new boolean[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(nextInt(), nextInt());
			bounds[i] = new Bounds();
		}

		for (int i = 0; i < m; i++) {
			int part1 = nextInt() - 1;
			int part2 = nextInt() - 1;

			cows[part1].connected.add(part2);
			cows[part2].connected.add(part1);
		}

		int holder = 0;
		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				dfs(i, cows, bounds, holder);
				holder++;
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < holder; i++) {
			if ((bounds[i].highX - bounds[i].lowX) * 2 + (bounds[i].highY - bounds[i].lowY) * 2 < ans) {
				ans = (bounds[i].highX - bounds[i].lowX) * 2 + (bounds[i].highY - bounds[i].lowY) * 2;
			}
		}

		for (int i = 0; i < n; i++) {
			bounds[i].print();
		}

		out.println(ans);
		out.close();
	}

	static void dfs(int index, Cow[] cows, Bounds[] bounds, int boundIndex) {
		if (seen[index]) return;

		seen[index] = true;

		if (cows[index].x < bounds[boundIndex].lowX) bounds[boundIndex].lowX = cows[index].x;
		if (cows[index].x > bounds[boundIndex].highX) bounds[boundIndex].highX = cows[index].x;
		if (cows[index].y < bounds[boundIndex].lowY) bounds[boundIndex].lowY = cows[index].y;
		if (cows[index].y > bounds[boundIndex].highY) bounds[boundIndex].highY = cows[index].y;

		for (int i : cows[index].connected) {
			dfs(i, cows, bounds, boundIndex);
		}
	}

	static class Bounds {
		int lowX = Integer.MAX_VALUE - 100;
		int highX = -1;
		int lowY = Integer.MAX_VALUE - 100;
		int highY = -1;

		void print() {
			System.out.println(lowX + ", " + highX + " and " + lowY + ", " + highY);
		}
	}

	static class Cow {
		int x, y;
	
		LinkedList<Integer> connected = new LinkedList<>();
	
		Cow(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void print() {
			System.out.print("This cow is connected to ");

			for (int i : connected) {
				System.out.print(i + ", ");
			}

			System.out.println();
		}
	}
}