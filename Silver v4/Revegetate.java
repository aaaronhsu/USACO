import java.util.*;
import java.io.*;

public class Revegetate {
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
		Cow[] cows = new Cow[m];
		boolean[] visited = new boolean[n];

		for (int i = 0; i < m; i++) {
			cows[i] = new Cow(next(), nextInt() - 1, nextInt() - 1);
		}

		long ans = 1;

		for (int i = 0; i < m; i++) {
			if (!visited[i]) {
				int hold = dfs(cows, pastures, i, visited, 1);

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

	static int dfs(Cow[] cows, int[] pastures, int index, boolean[] visited, int seed) {
		if (visited[cows[index].past1]) {
			if (pastures[cows[index].past1] != seed) return 0;
			return 1;	
		}

		visited[cows[index].past1] = true;

		int ret = 1;
		pastures[cows[index].past1] = seed;
		
		if (cows[index].type == 1) ret *= dfs(cows, pastures, cows[index].past2, visited, seed);
		else ret *= dfs(cows, pastures, cows[index].past2, visited, seed * -1);

		return ret;


	}

	static class Cow {
		int type;
		int past1, past2;

		int seed = 0;

		Cow(String type, int a, int b) {
			this.type = type.equals("S") ? 1 : -1;
			past1 = a;
			past2 = b;
		}


	}
}