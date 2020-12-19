import java.util.*;
import java.io.*;

public class Mooyomooyo {
	static StreamTokenizer in;

	static int n, k;
	static int[][] board;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("mooyomooyo.in")));
		PrintWriter out = new PrintWriter(new File("mooyomooyo.out"));
		
		n = nextInt();
		k = nextInt();

		board = new int[n][10];

		for (int i = 0; i < n; i++) {
			String holder = ((Long) nextLong()).toString();
			int asdf = holder.length();
			for (int add = 0; add < 10 - asdf; add++) {
				holder = "0" + holder;
			}

			for (int a = 9; a >= 0; a--) {
				board[i][a] = Integer.parseInt(holder.substring(a, a + 1));
			}
		}

		while (scan()) {

			System.out.println("---Prefall---");
			for (int i = 0; i < n; i++) {
				for (int a = 0; a < 10; a++) {
					System.out.print(board[i][a]);
				}
				System.out.println();
			}

			fall();

			System.out.println("---Postfall---");
			for (int i = 0; i < n; i++) {
				for (int a = 0; a < 10; a++) {
					System.out.print(board[i][a]);
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println();
		}


		for (int i = 0; i < n; i++) {
			for (int a = 0; a < 10; a++) {
				out.print(board[i][a]);
			}
			out.println();
		}
		out.close();
	}

	static boolean scan() {
		boolean found = false;

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < 10; a++) {
				if (board[i][a] != 0 && dfs(i, a, new boolean[n][10], board[i][a]) >= k) {
					clear(i, a, board[i][a]);
					found = true;
				}
			}
		}

		return found;
	}

	static int dfs(int x, int y, boolean[][] seen, int target) {
		if (x < 0 || y < 0 || x >= n || y >= 10 || seen[x][y]) return 0;
		seen[x][y] = true;
		if (board[x][y] != target) return 0;

		int hold = 1;

		hold += dfs(x + 1, y, seen, target);
		hold += dfs(x - 1, y, seen, target);
		hold += dfs(x, y + 1, seen, target);
		hold += dfs(x, y - 1, seen, target);

		return hold;
	}

	static void clear(int x, int y, int target) {
		if (x < 0 || y < 0 || x >= n || y >= 10 || board[x][y] != target) return;

		if (board[x][y] != target) return;

		board[x][y] = 0;

		clear(x + 1, y, target);
		clear(x - 1, y, target);
		clear(x, y + 1, target);
		clear(x, y - 1, target);
	}

	static void fall() {
		for (int i = 0; i < 10; i++) {
			for (int a = 0; a < n; a++) {

				if (board[a][i] == 0) {
					for (int j = a; j > 0; j--) {
						board[j][i] = board[j - 1][i];
					}
					board[0][i] = 0;
				}
			}
		}
	}
}