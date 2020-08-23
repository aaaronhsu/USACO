import java.io.*;
import java.util.LinkedList;

public class mootube {
	static StreamTokenizer in;
	static LinkedList<Edge>[] map;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("mootube.in")));
		PrintWriter out = new PrintWriter(new File("mootube.out"));

		int n = nextInt();
		int m = nextInt();

		map = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			map[i] = new LinkedList<Edge>();
		}

		for (int i = 0; i < n - 1; i++) {
			int p = nextInt() - 1;
			int q = nextInt() - 1;
			int r = nextInt();

			map[p].add(new Edge(q, r));
			map[q].add(new Edge(p, r));
		}

		for (int i = 0; i < m; i++) {
			int rel = nextInt();
			int start = nextInt() - 1;

			out.println(dfs(start, rel, new boolean[n]));
		}

		out.close();
	}

	static int dfs(int current, int rel, boolean[] visited) {

		if (visited[current]) return 0;

		visited[current] = true;

		int holder = 0;

		for (Edge con : map[current]) {

			if (visited[con.neigh]) continue;
			if (con.val >= rel) {
				holder += 1 + dfs(con.neigh, rel, visited);
			}
		}

		return holder;
	}

	static class Edge {
		int neigh;
		int val;

		Edge(int neigh, int val) {
			this.neigh = neigh;
			this.val = val;
		}
	}
}