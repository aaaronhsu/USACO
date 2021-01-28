import java.util.*;
import java.io.*;

public class _Template {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("paintbarn.in")));
		PrintWriter out = new PrintWriter(new File("paintbarn.out"));

		int n = nextInt();
		int k = nextInt();

		int[][] board = new int[201][201];
		int[][] close = new int[201][201];
		int[][] sub = new int[201][201];

		for (int i = 0; i < n; i++) {
			board[nextInt() + 1][nextInt() + 1]++;
			board[nextInt() + 1][nextInt() + 1]--;
		}

		for (int i = 0; i < 201; i++) {
			for (int j = 0; j < 201; j++) {
				board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];

				if (board[i][j] == k) sub[i][j]++;
				if (board[i][j] == k - 1) close[i][j]++;
			}
		}

		for (int i = 0; i < 201; i++) {
			for (int j = 0; j < 201; j++) {
				sub[i][j] += sub[i - 1][j] + sub[i][j - 1] - sub[i - 1][j - 1];
				close[i][j] += close[i - 1][j] + close[i][j - 1] - close[i - 1][j - 1];
			}
		}

		int extra1 = 0;
		int extra2 = 0;

		Cow ex1 = new Cow(0, 0, 0, 0);
		Cow ex2 = new Cow(0, 0, 0, 0);

		

	}

	static class Cow {
		int x1, x2, y1, y2;

		Cow (int a, int b, int c, int d) {
			x1 = a;
			x2 = b;
			y1 = c;
			y2 = d;
		}

		public boolean overlap(Cow other) {
			if (x1 <= other.x1 && other.x1 <= x2) return false;
			if (x1 <= other.x2 && other.x2 <= x2) return false;

			if (y1 <= other.y1 && other.y1 <= y2) return false;
			if (y2 <= other.y2 && other.y2 <= y2) return false;

			return true;

		}
	}
}