import java.util.*;
import java.io.*;

public class multimoo {
	static StreamTokenizer in;

	static int n;
	static int[][] board;

	static boolean[][] seen;
	static HashSet<Pair>[][] visited;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("multimoo.in")));
		PrintWriter out = new PrintWriter(new File("multimoo.out"));

		n = nextInt();
		board = new int[n][n];
		seen = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				board[i][a] = nextInt();
			}
		}

		int ans1 = -1;

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				int dfs1 = dfs(i, a, new int[] {board[i][a], board[i][a]});

				if (dfs1 > ans1) ans1 = dfs1;
			}
		}

		out.println(ans1);

		visited = new HashSet[n][n];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				visited[i][a] = new HashSet<Pair>();
			}
		}

		int ans2 = -1;

		for (int i = 1; i < n - 1; i++) {
			for (int a = 1; a < n - 1; a++) {

				int[] holder = new int[4];

				holder[0] = dfs2(i, a, new int[] {board[i][a], board[i + 1][a]});
				holder[1] = dfs2(i, a, new int[] {board[i][a], board[i - 1][a]});
				holder[2] = dfs2(i, a, new int[] {board[i][a], board[i][a + 1]});
				holder[3] = dfs2(i, a, new int[] {board[i][a], board[i][a - 1]});
				Arrays.sort(holder);

				if (holder[3] > ans2) ans2 = holder[3];
				
			}
		}
		
		out.println(ans2);

		out.close();
	}

	static int dfs(int x, int y, int[] target) {
		if (x >= n || y >= n || x < 0 || y < 0 || seen[x][y]) {
			return 0;
		}

		seen[x][y] = true;

		int holder = 0;

		if (board[x][y] == target[0] || board[x][y] == target[1]) {
			holder += 1 + 
				dfs(x + 1, y, target) +
				dfs(x - 1, y, target) +
				dfs(x, y + 1, target) +
				dfs(x, y - 1, target);
		}
		
		return holder;
	}

	static int dfs2(int x, int y, int[] target) {
		if (x >= n || y >= n || x < 0 || y < 0 || visited[x][y].contains(new Pair(target[0], target[1]))) {
			return 0;
		}

		visited[x][y].add(new Pair(target[0], target[1]));

		int holder = 0;

		if (board[x][y] == target[0] || board[x][y] == target[1]) {
			holder += 1 + 
				dfs2(x + 1, y, target) +
				dfs2(x - 1, y, target) +
				dfs2(x, y + 1, target) +
				dfs2(x, y - 1, target);
		}
		
		return holder;
	}

	static class Pair {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		} 


		// removes hashCode
		@Override
		public int hashCode() {
			return 31 * 101 + a + b;
		}

		// removes other
		@Override
		public boolean equals(Object other) {
			Pair temp = (Pair)other;
			return (temp.a == a && temp.b == b) || (temp.a == b && temp.b == a);
		}
	}
}