import java.util.*;
import java.io.*;

public class Fenceplan {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("fenceplan.in")));
		PrintWriter out = new PrintWriter(new File("fenceplan.out"));

		int n = nextInt();
		int m = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(nextInt(), nextInt());
		}

		LinkedList[] connections = new LinkedList[n];

		for (int i = 0; i < n; i++) connections[i] = new LinkedList<Integer>(); 

		for (int i = 0; i < m; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			connections[a].add(b);
			connections[b].add(a);
		}

		boolean[] seen = new boolean[n];

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int[] data = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};

			if (!seen[i]) {
				dfs(i, seen, cows, connections, data);
				ans = Integer.min(ans, perimeter(data));
			}
		}

		out.println(ans);
		out.close();
	}

	static int perimeter(int[] data) {
		return ((data[1] - data[0]) * 2) + ((data[3] - data[2]) * 2);
	}

	static void dfs(int index, boolean[] seen, Cow[] cows, LinkedList[] connections, int[] data) {
		if (seen[index]) return;

		data[0] = Integer.min(data[0], cows[index].x);
		data[1] = Integer.max(data[1], cows[index].x);
		
		data[2] = Integer.min(data[2], cows[index].y);
		data[3] = Integer.max(data[3], cows[index].y);

		seen[index] = true;

		for (int i : (LinkedList<Integer>) connections[index]) {
			dfs(i, seen, cows, connections, data);
		}
	}

	static class Cow {
		int x, y;

		Cow (int a, int b) {
			x = a;
			y = b;
		}
	}
}