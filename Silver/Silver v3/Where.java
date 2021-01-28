import java.util.*;
import java.io.*;

public class Where {
	static StreamTokenizer in;
	static int n;

	static char[][] board;
	static LinkedList<Integer> ignoreX;
	static LinkedList<Integer> ignoreY;
	static int ans = 0;

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
		in = new StreamTokenizer(new BufferedReader(new FileReader("where.in")));
		PrintWriter out = new PrintWriter(new File("where.out"));

		n = nextInt();

		board = new char[n][n];

		for (int i = 0; i < n; i++) {
			board[i] = next().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		ignoreX = new LinkedList<>();
		ignoreY = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {

			if (ignoreX.contains(i)) continue;

			if (end(i, i)) ans++;

			for (int a = i + 1; a < n; a++) {

				if (ignoreY.contains(a)) continue;
				if (end(i, a)) ans++;

				if (end(a, i)) ans++;
			}
		}

		out.println(ans);
		out.close();
	}

	static boolean end(int x, int y) {
		for (int i = n - 1; i >= 0; i--) {
			if (check(x, y, i, i)) {
				for (int j = x; j <= i; j++) {
					ignoreX.add(j);
					ignoreY.add(j);
				}

				return true;
			}

			for (int a = i - 1; a >= 0; a--) {
				if (check(x, y, i, a)) {
					for (int j = x; j <= i; j++) {
						ignoreX.add(j);
					}
	
					for (int k = y; k <= a; k++) {
						ignoreY.add(k);
					}
	
					return true;
				}

				if (check(x, y, a, i)) {
					for (int j = x; j <= a; j++) {
						ignoreX.add(j);
					}
	
					for (int k = y; k <= i; k++) {
						ignoreY.add(k);
					}
	
					return true;
				}
			}
		}

		return false;
	}

	static boolean check(int x1, int y1, int x2, int y2) {

		boolean[][] seen = new boolean[n][n];
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = x1; i <= x2; i++) {
			for (int a = y1; a <= y2; a++) {


				if (!seen[i][a]) {
					char hold = board[i][a];

					if (map.keySet().contains(hold)) {
						map.put(hold, map.get(hold) + 1);
					}
					else {
						if (map.keySet().size() == 2) {
							return false;
						}
						else {
							map.put(hold, 1);
						}
					}

					dfs(i, a, board[i][a], seen, x1, x2, y1, y2);
				}
			}
		}

		boolean single = false;
		boolean more = false;

		if (map.keySet().size() == 2) {
			for (char i : map.keySet()) {
				if (map.get(i) == 1) single = true;
				else more = true;
			}
			return single && more;
		}
		return false;
	}

	static void dfs(int x, int y, char target, boolean[][] seen, int lowX, int highX, int lowY, int highY) {
		if (x < lowX || x > highX || y < lowY || y > highY || seen[x][y] || board[x][y] != target) return;

		seen[x][y] = true;

		dfs(x + 1, y, target, seen, lowX, highX, lowY, highY);
		dfs(x - 1, y, target, seen, lowX, highX, lowY, highY);
		dfs(x, y + 1, target, seen, lowX, highX, lowY, highY);
		dfs(x, y - 1, target, seen, lowX, highX, lowY, highY);

	}
}