import java.util.*;
import java.io.*;

public class Countcross {
	static StreamTokenizer in;
	
	static int n, k, r;
	static boolean[][] seen;
	static boolean[][] board;
	static LinkedList[][] restrict;

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

		LinkedList<Integer> components = new LinkedList<>();

		restrict = new LinkedList[n][n];
		board = new boolean[n][n];
		seen = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				restrict[i][a] = new LinkedList<Integer>();
			}
		}

		for (int i = 0; i < r; i++) {
			int x1 = nextInt() - 1;
			int y1 = nextInt() - 1;
			int x2 = nextInt() - 1;
			int y2 = nextInt() - 1;

			restrict[x1][y1].add(new Restriction(x2, y2));
			restrict[x2][y2].add(new Restriction(x1, y1));
		}

		for (int i = 0; i < k; i++) {
			board[nextInt() - 1][nextInt() - 1] = true;
		}

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				if (!seen[i][a]) {
					components.add(dfs(i, a));
				}
			}
		}

		int ans = 0;
		int size = components.size();
		for (int i = 0; i < size; i++) {
			int compare = components.pop();
			for (int a : components) {
				ans += compare * a;
			}
		}

		out.println(ans);
		out.close();
		
	}

	static int dfs(int x, int y) {
		if (x < 0 || y < 0 || x >= n || y >= n || seen[x][y]) return 0;

		seen[x][y] = true;

		int holder = 0;
		if (board[x][y]) holder++;

		if (!restrict[x][y].contains(new Restriction(x + 1, y))) holder += dfs(x + 1, y);
		if (!restrict[x][y].contains(new Restriction(x - 1, y))) holder += dfs(x - 1, y);
		if (!restrict[x][y].contains(new Restriction(x, y + 1))) holder += dfs(x, y + 1);
		if (!restrict[x][y].contains(new Restriction(x, y - 1))) holder += dfs(x, y - 1);

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

		@Override
		public int compareTo(Restriction other){
			if (x == other.x) return y - other.y;
			return x - other.x;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object other) {
			Restriction temp = (Restriction)other;
			return temp.x == x && temp.y == y;
		}
	}
}