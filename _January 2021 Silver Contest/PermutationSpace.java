import java.util.*;
import java.io.*;

public class PermutationSpace {
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
		in = new StreamTokenizer(System.in);

		int n = nextInt();
		// this ArrayList will hold all the permutations of numbers 0 to n
		ArrayList<boolean[][]> combos = new ArrayList<>();
		ArrayList<Integer> potentialAns = new ArrayList<>();

		int[][] values = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				values[i][a] = nextInt();
			}
		}
		
		combos.add(new boolean[n][n]);
		potentialAns.add(0);

		boolean[][] init = new boolean[n][n];
		init[0][0] = true;
		combos.add(init);
		potentialAns.add(values[0][0]);

		for (int i = 0; i < n; i++) {
			for (int a = 0 + (i == 0 ? 1 : 0); a < n; a++) {
				ArrayList<boolean[][]> longerCombos = new ArrayList<>();
				ArrayList<Integer> longerAns = new ArrayList<>();

				for (int b = 0; b < combos.size(); b++) {
					if (isValid(i, a, 0, combos.get(b), n)) {
						longerCombos.add(combos.get(b));
						longerAns.add(potentialAns.get(b));
					}

					if (isValid(i, a, 1, combos.get(b), n)) {
						boolean[][] hold = clone(combos.get(b), i, a);
						hold[i][a] = true;
						longerCombos.add(hold);
						longerAns.add(potentialAns.get(b) + values[i][a]);
					}
				}

				combos = longerCombos;
				potentialAns = longerAns;
			}
		}

		int ans = 0;
		
		for (int i : potentialAns) ans = Integer.max(ans, i);

		System.out.println(ans);
	}

	static boolean[][] clone(boolean[][] board, int x, int y) {
		boolean[][] ret = new boolean[board.length][board.length];

		boolean done = false;

		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board.length; a++) {
				if (x == i && a == y) {
					done = true;
					break;
				}
				ret[i][a] = board[i][a];
			}
			if (done) break;
		}

		return ret;
	}

	static boolean isValid (int x, int y, int start, boolean[][] board, int n) {
		int valid = start;

		// top left box
		if (!(x == 0 || y == 0)) {
			if (board[x - 1][y - 1]) valid++;
			if (board[x - 1][y]) valid++;
			if (board[x][y - 1]) valid++;
			if (valid != 2) return false;
		}

		if (valid > 2) return false;


		valid = start;
		// top right box
		if (x > 0 && y < n - 1) {
			if (board[x - 1][y]) valid++;
			if (board[x - 1][y + 1]) valid++;
			if (board[x][y + 1]) valid++;
		}

		if (valid > 2) return false;

		return true;
	}
}