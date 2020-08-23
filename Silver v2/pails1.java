import java.util.*;
import java.io.*;
import java.lang.*;

public class pails1 {
	static StreamTokenizer in;
	
	static int x, y, k, m;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static int[][] maxSteps;

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("pails.in")));
		PrintWriter out = new PrintWriter(new File("pails.out"));

		x = nextInt();
		y = nextInt();
		k = nextInt();
		m = nextInt();

		boolean[][] visited = new boolean[101][101];
		maxSteps = new int[101][101];

		dfs(visited, k, 0, 0);
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < 101; i++) {
			for (int a = 0; a < 101; a++) {
				if (visited[i][a] && Math.abs((i + a) - m) < ans) ans = Math.abs((i + a) - m);
			}
		}

		out.println(ans);
		out.close();


	}

	static void dfs(boolean[][] visited, int stepsLeft, int a, int b) {
		if (a > 100 || b > 100 || stepsLeft == -1 || maxSteps[x][y] > stepsLeft) return;

		visited[a][b] = true;
		maxSteps[a][b] = stepsLeft - 1;

		dfs(visited, stepsLeft - 1, x, b);
		dfs(visited, stepsLeft - 1, a, y);
		dfs(visited, stepsLeft - 1, 0, b);
		dfs(visited, stepsLeft - 1, a, 0);

		if (a + b < y) dfs(visited, stepsLeft - 1, 0, b + a);
		else dfs(visited, stepsLeft - 1, a - (y - b), y);
		

		if (a + b < x) dfs(visited, stepsLeft - 1, a + b, 0);
		else dfs(visited, stepsLeft - 1, x, b - (x - a));

	}




}