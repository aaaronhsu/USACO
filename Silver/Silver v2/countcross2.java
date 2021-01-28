import java.util.*;
import java.io.*;

public class countcross2 {
	static StreamTokenizer in;
	
	static int n, k, r;

	static int[][][][] restrict;
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

		restrict = new int[n][n][4][2];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				Arrays.fill(restrict[i][a], new int[] {-1 , -1});
			}
		}

		for (int i = 0; i < r; i++) {
			int f1x = nextInt() - 1;
			int f1y = nextInt() - 1;
			int f2x = nextInt() - 1;
			int f2y = nextInt() - 1;

			for (int a = 0; i < 4; i++) {
				if (!restrict[f1x][f1y][a].equals(new int[] {-1, -1})) {
					restrict[f1x][f1y][a] = new int[] {f2x, f2y};
					break;
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

		out.println(ans);
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

		boolean fml = true;

		for (int i = 0; i < 4; i++) {
			if (restrict[x][y][i].equals(new int[] {x + 1, y})) fml = false;
		}
		if (fml) holder += dfs(x + 1, y, seen);


		fml = true;

		for (int i = 0; i < 4; i++) {
			if (restrict[x][y][i].equals(new int[] {x - 1, y})) fml = false;
		}
		if (fml) holder += dfs(x - 1, y, seen);


		fml = true;

		for (int i = 0; i < 4; i++) {
			if (restrict[x][y][i].equals(new int[] {x, y + 1})) fml = false;
		}
		if (fml) holder += dfs(x, y + 1, seen);


		fml = true;
		
		for (int i = 0; i < 4; i++) {
			if (restrict[x][y][i].equals(new int[] {x, y - 1})) fml = false;
		}
		if (fml) holder += dfs(x, y - 1, seen);

		return holder;
	}
}