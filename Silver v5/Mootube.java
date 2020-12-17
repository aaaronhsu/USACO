import java.util.*;
import java.io.*;

public class Mootube {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("mootube.in")));
		PrintWriter out = new PrintWriter(new File("mootube.out"));
		
		int n = nextInt();
		int q = nextInt();

		LinkedList[] connections = new LinkedList[n];

		for (int i = 0; i < n; i++) connections[i] = new LinkedList<Edge>();

		for (int i = 0; i < n - 1; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;
			int c = nextInt();

			connections[a].add(new Edge(b, c));
			connections[b].add(new Edge(a, c));
		}

		for (int i = 0; i < q; i++) {
			int rel = nextInt();
			int start = nextInt() - 1;

			out.println(dfs(start, new boolean[n], connections, rel) - 1);
		}

		out.close();
	}

	static int dfs(int index, boolean[] seen, LinkedList[] connections, int rel) {
		if (seen[index]) return 0;
		seen[index] = true;

		int hold = 1;

		for (Edge i : (LinkedList<Edge>) connections[index]) {
			if (i.rel >= rel) {
				hold += dfs(i.connection, seen, connections, rel);
			}
		}

		return hold;
	}

	static class Edge {
		int connection, rel;

		Edge (int a, int b) {
			connection = a;
			rel = b;
		}
	}
}