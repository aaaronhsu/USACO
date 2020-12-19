import java.util.*;
import java.io.*;

public class Where {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("where.in")));
		PrintWriter out = new PrintWriter(new File("where.out"));

		int n = nextInt();

		char[][] grid = new char[n][n];

		for (int i = 0; i < n; i++) {
			String hold = next();

			for (int a = 0; a < n; a++) {
				grid[i][a] = hold.charAt(a);
			}
		}

		System.out.println(Arrays.deepToString(grid));
	}
}