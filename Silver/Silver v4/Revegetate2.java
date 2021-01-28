import java.util.*;
import java.io.*;

public class Revegetate2 {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("revegetate.in")));
		PrintWriter out = new PrintWriter(new File("revegetate.out"));

		int n = nextInt(); // pastures
		int m = nextInt(); // cows

		int[] pastures = new int[n];
		boolean[] visited = new boolean[n];

		LinkedList[] cows = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new LinkedList<Cow>();
		}

		for (int i = 0; i < m; i++) {
			String type = next();
			int p1 = nextInt() - 1;
			int p2 = nextInt() - 1;

			cows[p1].add(new Cow(type, p2));
			cows[p2].add(new Cow(type, p1));
		}

		long ans = 1;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				int hold = dfs(cows, pastures, visited, i, 1);

				if (hold == 0) {
					ans = 0;
					break;
				}
				ans *= 10;
			}
			
		}

		out.println(ans);
		out.close();
	}

	static int dfs(LinkedList[] cows, int[] pastures, boolean[] visited, int index, int seed) {
		if (visited[index]) {
			if (pastures[index] != seed) return 0;
			return 1;
		}

		visited[index] = true;

		int ret = 1;
		pastures[index] = seed;

		for (Cow c : (LinkedList<Cow>) cows[index]) {
			if (c.type == 1) ret *= dfs(cows, pastures, visited, c.nextPasture, seed);
			else ret *= dfs(cows, pastures, visited, c.nextPasture, seed * -1);
		}

		return ret;


	}

	static class Cow {
		int type;
		int nextPasture;

		Cow(String type, int a) {
			this.type = type.equals("S") ? 1 : -1;
			nextPasture = a;
		}


	}
}