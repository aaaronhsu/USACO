import java.util.*;
import java.io.*;

public class countcross {
	static StreamTokenizer in;
	
	static int n, k, r;

	static LinkedList[][] restrict;
	static boolean[][] board;
	static boolean[][] compareBoard;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("countcross.in")));
		PrintWriter out = new PrintWriter(new File("countcross.out"));

		n = nextInt();
		k = nextInt();
		r = nextInt();

		board = new boolean[n][n];

		restrict = new LinkedList[n][n];
		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				restrict[i][a] = new LinkedList<Restriction>();
			}
		}

		for (int i = 0; i < r; i++) {
			int f1x = nextInt() - 1;
			int f1y = nextInt() - 1;
			int f2x = nextInt() - 1;
			int f2y = nextInt() - 1;

			System.out.println(f2x + ", " + f2y + " to " + new Restriction(f1x, f1y).print());

			restrict[f1x][f1y].add(new Restriction(f2x, f2y));
			restrict[f2x][f2y].add(new Restriction(f1x, f1y));
		}

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				if (restrict[i][a].size() != 0) {
					for (Restriction b : (LinkedList<Restriction>) restrict[i][a]) {
						System.out.println("Restriction from " + i + ", " + a + " to " + b.print());
					}
				}
			}
		}

		for (int i = 0; i < k; i++) {
			board[nextInt() - 1][nextInt() - 1] = true;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				if (board[i][a]) {
					compareBoard = board.clone();
					compareBoard[i][a] = false;
					ans += (k - 1) - dfs(i, a, new boolean[n][n]);
				}
			}
		}

		out.println(ans / 2);
		out.close();


		
	}

	static int dfs(int x, int y, boolean[][] seen) {
		if (x < 0 || y < 0 || x >= n || y >= n || seen[x][y]) {
			return 0;
		}

		seen[x][y] = true;

		int holder = 0;

		if (compareBoard[x][y]) {
			holder++;
			compareBoard[x][y] = false;
		}

		if (!restrict[x][y].contains(new Restriction(x + 1, y))) holder += dfs(x + 1, y, seen);
		if (!restrict[x][y].contains(new Restriction(x - 1, y))) holder += dfs(x - 1, y, seen);
		if (!restrict[x][y].contains(new Restriction(x, y + 1))) holder += dfs(x, y + 1, seen);
		if (!restrict[x][y].contains(new Restriction(x, y - 1))) holder += dfs(x, y - 1, seen);

		return holder;
	}

	static class Restriction implements Comparable<Restriction> {
		int x, y;

		Restriction(int x, int y) {
			this.x = x;
			this.y = y;
		}

		String print() {
			return x + ", " + y;
		}

		@Override // making sure that comparing the nodes compares values, not hash values
		public int compareTo(Restriction other){
			if (x == other.x) return y - other.y;
			return x - other.x;
		}

		// removes hashCode
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		// removes other
		@Override
		public boolean equals(Object other) {
			Restriction temp = (Restriction)other;
			return temp.x == x && temp.y == y;
		}
	}
}