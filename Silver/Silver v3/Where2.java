import java.util.*;
import java.io.*;

public class Where2 {
	static StreamTokenizer in;
	static int n;

	static char[][] board;
	static LinkedList<Restriction> restriction = new LinkedList<>();
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
		
		for (int i = 0; i < n; i++) {

			if (end(i, i)) ans++;

			for (int a = i + 1; a < n; a++) {
				if (end(i, a)) ans++;
				if (end(a, i)) ans++;
			}
		}

		out.println(ans);
		out.close();
	}

	static boolean end(int x, int y) {
		for (int i = x; i < n; i++) {
			if (check(x, y, i, i)) {
				addRestrictions(x, y, i, i);

				return true;
			}

			for (int a = y; a < n; a++) {
				if (check(x, y, i, a)) {
					addRestrictions(x, y, i, a);
	
					return true;
				}

				if (check(x, y, a, i)) {
					addRestrictions(x, y, a, i);
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

					if (dfs(i, a, board[i][a], seen, x1, x2, y1, y2)) return false;
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

	static boolean dfs(int x, int y, char target, boolean[][] seen, int lowX, int highX, int lowY, int highY) {
		if (x < lowX || x > highX || y < lowY || y > highY || seen[x][y] || board[x][y] != target) return false;

		if (restriction.contains(new Restriction(x, y))) return true;
		seen[x][y] = true;

		dfs(x + 1, y, target, seen, lowX, highX, lowY, highY);
		dfs(x - 1, y, target, seen, lowX, highX, lowY, highY);
		dfs(x, y + 1, target, seen, lowX, highX, lowY, highY);
		dfs(x, y - 1, target, seen, lowX, highX, lowY, highY);

		return false;

	}

	static void addRestrictions(int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2; i++) {
			for (int a = y1; a <= y2; a++) {
				restriction.add(new Restriction(i, a));
			}
		}
	}

	static class Restriction implements Comparable<Restriction> {
		int x, y;

		Restriction(int a, int b) {
			x = a;
			y = b;
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