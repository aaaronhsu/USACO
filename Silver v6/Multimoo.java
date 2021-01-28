import java.util.*;
import java.io.*;

public class Multimoo {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("multimoo.in")));
		PrintWriter out = new PrintWriter(new File("multimoo.out"));

		int n = nextInt();
		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = nextInt();
			}
		}

		int ans1 = 0;
		int ans2 = 0;

		boolean[][] seen1 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!seen1[i][j]) {
					ans1 = Integer.max(ans1, dfs1(i, j, board, seen1, board[i][j]));
				}

				ans2 = Integer.max(ans2, dfsStart(i, j, board));
			}
		}

		out.println(ans1);
		out.println(ans2);
		out.close();
	}

	static int dfs1(int x, int y, int[][] board, boolean[][] seen, int valid) {
		if (x < 0 || y < 0 || x >= seen.length || y >= seen.length || seen[x][y] || board[x][y] != valid) return 0;

		seen[x][y] = true;

		return 1 +
		dfs1(x + 1, y, board, seen, valid) +
		dfs1(x - 1, y, board, seen, valid) +
		dfs1(x, y + 1, board, seen, valid) +
		dfs1(x, y - 1, board, seen, valid);
	}

	static int dfs2(int x, int y, int[][] board, boolean[][] seen, int valid1, int valid2) {
		if (x < 0 || y < 0 || x >= board.length || y >= board.length || seen[x][y] || !(board[x][y] == valid1 || board[x][y] == valid2)) return 0;

		seen[x][y] = true;

		return 1 +
		dfs2(x + 1, y, board, seen, valid1, valid2) +
		dfs2(x - 1, y, board, seen, valid1, valid2) +
		dfs2(x, y + 1, board, seen, valid1, valid2) +
		dfs2(x, y - 1, board, seen, valid1, valid2);
	}

	static int dfsStart(int x, int y, int[][] board) {
		int ret = 0;
		boolean[][] seen = new boolean[board.length][board.length];

		if (x != 0) ret = Integer.max(ret, dfs2(x, y, board, seen, board[x][y], board[x - 1][y]));
		seen[x][y] = false;

		if (x != board.length - 1) ret = Integer.max(ret, dfs2(x, y, board, seen, board[x][y], board[x + 1][y]));
		seen[x][y] = false;

		if (y != 0) ret = Integer.max(ret, dfs2(x, y, board, seen, board[x][y], board[x][y - 1]));
		seen[x][y] = false;

		if (y != board.length - 1) ret = Integer.max(ret, dfs2(x, y, board, seen, board[x][y], board[x][y + 1]));

		return ret;
	}
}