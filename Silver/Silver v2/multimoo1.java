import java.util.*;
import java.io.*;

public class multimoo1 {
	static StreamTokenizer in;
	
	static int n;
	static int[][] board;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("multimoo.in")));
		PrintWriter out = new PrintWriter(new File("multimoo.out"));

		// reading input
		n = nextInt();
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				board[i][a] = nextInt();
			}
		}


		// start dfs1
		boolean[][] dfs1seen = new boolean[n][n];
		int dfs1 = -1;

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				
				int holder = dfs1(i, a, board[i][a], dfs1seen);
				if (holder > dfs1) dfs1 = holder;
			}
		}

		out.println(dfs1);


		// start dfs2
		HashSet<Pair>[][] dfs2seen = new HashSet[n][n];
		int dfs2 = -1;

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				dfs2seen[i][a] = new HashSet<Pair>();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				int[] holder = new int[4];

				if (i != n - 1) holder[0] = dfs2(i, a, board[i][a], board[i + 1][a], dfs2seen);
				if (i != 0) holder[1] = dfs2(i, a, board[i][a], board[i - 1][a], dfs2seen);
				if (a != n - 1) holder[2] = dfs2(i, a, board[i][a], board[i][a + 1], dfs2seen);
				if (a != 0) holder[3] = dfs2(i, a, board[i][a], board[i][a - 1], dfs2seen);

				Arrays.sort(holder);

				if (holder[3] > dfs2) dfs2 = holder[3];

			}
		}

		out.println(dfs2);
		out.close();

	}

	static int dfs1(int x, int y, int target, boolean[][] seen) {
		if (x >= n || y >= n || x < 0 || y < 0 || seen[x][y]) {
			return 0;
		}

		seen[x][y] = true;

		if (board[x][y] == target) {
			return 1 + 
				dfs1(x + 1, y, target, seen) +
				dfs1(x - 1, y, target, seen) +
				dfs1(x, y + 1, target, seen) +
				dfs1(x, y - 1, target, seen);
		}
		
		return 0;
	}

	static int dfs2(int x, int y, int target1, int target2, HashSet<Pair>[][] seen) {
		if (x >= n || y >= n || x < 0 || y < 0 || seen[x][y].contains(new Pair(target1, target2))) {
			return 0;
		}

		seen[x][y].add(new Pair(target1, target2));

		int holder = 0;

		if (board[x][y] == target1 || board[x][y] == target2) {
			holder += 1 + 
				dfs2(x + 1, y, target1, target2, seen) +
				dfs2(x - 1, y, target1, target2, seen) +
				dfs2(x, y + 1, target1, target2, seen) +
				dfs2(x, y - 1, target1, target2, seen);
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