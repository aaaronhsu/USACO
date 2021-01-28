import java.util.*;
import java.io.*;

public class Lightson {
	static StreamTokenizer in;

	static boolean[][] rooms;
	static boolean[][] seen;
	static LinkedList[][] lightSwitch;
	static int ans = 1;
	static int n;

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
		in = new StreamTokenizer(new BufferedReader(new FileReader("lightson.in")));
		PrintWriter out = new PrintWriter(new File("lightson.out"));

		n = nextInt();
		int m = nextInt();
		lightSwitch = new LinkedList[n][n];

		rooms = new boolean[n][n];
		seen = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				lightSwitch[i][a] = new LinkedList<Switches>();
			}
		}
		rooms[0][0] = true;

		for (int i = 0; i < m; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;
			int c = nextInt() - 1;
			int d = nextInt() - 1;

			lightSwitch[a][b].add(new Switches(c, d));
		}

		dfs(0, 0);

		out.println(ans);
		out.close();



	}

	static void dfs(int x, int y) {
		if (x < 0 || y < 0 || x >= n || y >= n || seen[x][y] || !rooms[x][y]) return;

		seen[x][y] = true;

		boolean on = false;
		for (Switches i : (LinkedList<Switches>) lightSwitch[x][y]) {
			if (!rooms[i.x][i.y]) {
				on = true;
				ans++;
				rooms[i.x][i.y] = true;
			}
		}

		if (on) {
			seen = new boolean[n][n];
		}

		dfs(x + 1, y);
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x, y - 1);
		
	}

	static class Switches {
		int x, y;

		Switches (int a, int b) {
			x = a;
			y = b;
		}
	}
}