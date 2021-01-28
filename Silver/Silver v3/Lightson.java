import java.util.*;
import java.io.*;

public class Lightson {
	static StreamTokenizer in;

	static int n, m;
	static Room[][] board;
	static boolean[][] seen;

	static int ans = 1;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("lightson.in")));
		PrintWriter out = new PrintWriter(new File("lightson.out"));

		n = nextInt();
		m = nextInt();

		board = new Room[n][n];
		seen = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				board[i][a] = new Room(i, a);
			}
		}

		board[0][0].lights = true;

		for (int i = 0; i < m; i++) {
			int x = nextInt() - 1;
			int y = nextInt() - 1;

			board[x][y].connections.add(new Connection(nextInt() - 1, nextInt() - 1));
		}

		while(dfs(0, 0)) {
			seen = new boolean[n][n];
		}

		out.println(ans);
		out.close();
	}

	static boolean dfs(int x, int y) {
		if (x < 0 || y < 0 || x >= n || y >= n || seen[x][y] || !board[x][y].lights) return false;


		seen[x][y] = true;

		// there is a light switch
		if (board[x][y].connections.size() > 0) {
			for (Connection i : board[x][y].connections) {

				if (!board[i.x][i.y].lights) {
					ans++;
				}
				board[i.x][i.y].lights = true;
			}

			board[x][y].connections = new LinkedList<>();
			return true;
		}

		return dfs(x + 1, y) || dfs(x - 1, y) || dfs(x, y + 1) || dfs(x, y - 1);

		
	}

	static class Room {
		int x, y;
		boolean lights;

		LinkedList<Connection> connections = new LinkedList<>();

		Room (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Connection {
		int x, y;

		Connection (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}