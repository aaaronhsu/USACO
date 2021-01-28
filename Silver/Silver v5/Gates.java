import java.util.*;
import java.io.*;

public class Gates {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("gates.in")));
		PrintWriter out = new PrintWriter(new File("gates.out"));

		int n = nextInt();

		String data = next();

		int q = 5000;

		boolean[][] field = new boolean[q][q];

		int x = q / 2;
		int y = q / 2;

		for (char i : data.toCharArray()) {
			if (i == 'N') {
				field[x][y] = true;
				x -= 1;
				field[x][y] = true;
				x -= 1;
			}
			else if (i == 'S') {
				field[x][y] = true;
				x += 1;
				field[x][y] = true;
				x += 1;
			}
			else if (i == 'E') {
				field[x][y] = true;
				y += 1;
				field[x][y] = true;
				y += 1;
			}
			else {
				field[x][y] = true;
				y -= 1;
				field[x][y] = true;
				y -= 1;
			}
		}

		int ans = -1;

		for (int i = 0; i < q; i++) {
			for (int a = 0; a < q; a++) {
				if (!field[i][a]) {
					ans++;
					dfs(i, a, field);
				}
			}
		}

		out.println(ans);
		out.close();


	}

	static void dfs(int x, int y, boolean[][] field) {
		if (x < 0 || y < 0 || x >= 5000 || y >= 5000 || field[x][y]) return;

		field[x][y] = true;

		dfs(x + 1, y, field);
		dfs(x - 1, y, field);
		dfs(x, y + 1, field);
		dfs(x, y - 1, field);
	}
}