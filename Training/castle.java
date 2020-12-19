/*
ID: pufflew1
LANG: JAVA
TASK: castle
*/

import java.util.*;
import java.io.*;

public class castle {

	static int n,m;

	static StreamTokenizer in;
	static Room[][] rooms;
	static int[][] board;
	static HashMap<Integer, LinkedList<Integer>> connections = new HashMap<>();
	
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

		in = new StreamTokenizer(new BufferedReader(new FileReader("castle.in")));
		PrintWriter out = new PrintWriter(new File("castle.out"));

		m = nextInt();
		n = nextInt();

		rooms = new Room[n][m];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < m; a++) {
				rooms[i][a] = new Room(nextInt());
			}
		}

		board = new int[n][m];
		boolean[][] seen = new boolean[n][m];
		int sum = 0;
		int maxSize = 0;

		LinkedList<int[]> home = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < m; a++) {
				if (!seen[i][a]) {
					home.add(new int[] {i, a});
					int hold = dfs(i, a, seen, sum);
					sum++;
					if (hold > maxSize) maxSize = hold;
				}
			}
		}


		out.println(sum);
		out.println(maxSize);

		// int x = 0;
		// int y = 0;

		// for (int i = 0; i < sum; i++) {
		// 	int[] start = home.poll();
		// 	for (int a = i + 1; a < sum; a++) {
		// 		seen = new boolean[n][m];

		// 		int hold = dfs2(start[0], start[1], i, a, seen);

		// 		if (hold > ans) {
		// 			ans = hold;
		// 			x = i;
		// 			y = a;
		// 		}
		// 	}
		// }
	

		seen = new boolean[n][m];

		int[] space = new int[sum];

		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board[0].length; a++) {
				if (!seen[i][a]) {
					int hold = board[i][a];

					space[hold] = dfs3(i, a, seen, hold);
				}
			}
		}

		int[] poop = new int[sum];

		for (int i = 0; i < sum; i++) {
			int best = 0;

			for (int a : connections.get(i)) {
				if (space[a] > best) best = space[a];
			}

			poop[i] = space[i] + best;
		}

		Arrays.sort(poop);
		out.println(poop[poop.length - 1]);







		boolean found = false;

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		System.out.println(x + " " + y);

		for (int i = n - 1; i >= 0; i--) {
			for (int a = 0; a <= m - 1; a++) {
				if (i > 0 && ((board[i][a] == x && board[i - 1][a] == y) || (board[i][a] == y && board[i - 1][a] == x))) {
					out.println((i + 1) + " " + (a + 1) + " N");
					found = true;
				}

				if (found) break;
				
				if (a < m - 1 && ((board[i][a] == x && board[i][a + 1] == y) || (board[i][a] == y && board[i][a + 1] == x))) {
					out.println((i + 1) + " " + (a + 1) + " E");
					found = true;
				}

				if (found) break;
			}

			if (found) break;
		}

		out.close();
	}

	static int dfs(int x, int y, boolean[][] seen, int label) {
		if (x < 0 || y < 0 || x >= n || y >= m || seen[x][y]) return 0;

		seen[x][y] = true;
		int hold = 1;

		board[x][y] = label;

		if (!rooms[x][y].restrictions[0]) hold += dfs(x + 1, y, seen, label);
		if (!rooms[x][y].restrictions[1]) hold += dfs(x, y + 1, seen, label);
		if (!rooms[x][y].restrictions[2]) hold += dfs(x - 1, y, seen, label);
		if (!rooms[x][y].restrictions[3]) hold += dfs(x, y - 1, seen, label);

		return hold;
	}

	static int dfs2(int x, int y, int t1, int t2, boolean[][] seen) {
		if (x < 0 || y < 0 || x >= n || y >= m || seen[x][y]) return 0;

		if (board[x][y] == t1 || board[x][y] == t2) {
			seen[x][y] = true;

			return 1 
			+ dfs2(x + 1, y, t1, t2, seen)
			+ dfs2(x, y + 1, t1, t2, seen)
			+ dfs2(x - 1, y, t1, t2, seen)
			+ dfs2(x, y - 1, t1, t2, seen);
		}
		return 0;
	}

	static int dfs3(int x, int y, boolean[][] seen, int target) {
		if (x < 0 || y < 0 || x >= n || y >= m || seen[x][y]) return 0;

		if (board[x][y] == target) {
			seen[x][y] = true;

			return 1
			+ dfs3(x + 1, y, seen, target)
			+ dfs3(x, y + 1, seen, target)
			+ dfs3(x - 1, y, seen, target)
			+ dfs3(x, y - 1, seen, target);
		}
		else {
			if (connections.get(target) == null) {
				LinkedList<Integer> hold = new LinkedList<>();
				hold.add(target);

				connections.put(target, hold);
			}
			else {

				LinkedList<Integer> butt = connections.get(target);
				butt.add(board[x][y]);

				connections.put(target, butt);
			}
			
			return 0;
		}
	}

	static class Room {
		boolean[] restrictions = new boolean[4];
		// south, east, north, west

		Room (int n) {
			String str = Integer.toBinaryString(n);

			while (str.length() != 4) {
				str = "0" + str;
			}

			for (int i = 0; i < 4; i++) {
				if (str.charAt(i) == '1') {
					restrictions[i] = true;
				}
			}
		}
	}
}