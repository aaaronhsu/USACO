import java.util.*;
import java.io.*;

public class Revegetate2 {
	static StreamTokenizer in;

	static boolean[] seen;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("revegetate.in")));
		PrintWriter out = new PrintWriter(new File("revegetate.out"));

		int n = nextInt();
		int m = nextInt();

		LinkedList[] fields = new LinkedList[n];
		seen = new boolean[n];

		for (int i = 0; i < n; i++) {
			fields[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			next();
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			fields[a].add(b);
			fields[b].add(a);
		}


		out.print(1);
		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				dfs(i, fields);
				out.print(0);
			}
		}

		out.println();
		out.close();
	}

	static void dfs(int current, LinkedList[] fields) {
		if (seen[current]) return;

		seen[current] = true;

		for (int i : (LinkedList<Integer>) fields[current]) {
			dfs(i, fields);
		}
	}
}