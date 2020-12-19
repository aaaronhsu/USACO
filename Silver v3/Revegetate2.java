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

		Node[] fields = new Node[m];
		for (int i = 0; i < m; i++) {
			String hold = next();
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			fields[i] = new Node(a, b, hold);
		}

		int components = 0;

		boolean[] seen = new boolean[m];
		int[] seed = new int[n];

		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				components++;

				if (!dfs(i, fields, seed, 1)) {
					out.println(0);
					out.close();
					break;
				}
			}
		}

		StringBuilder str = new StringBuilder();

		str.append(1);

		for (int i = 0; i < components; i++) {
			str.append(0);
		}

		out.println(str.toString());
		out.close();
	}

	static boolean dfs(int current, Node[] fields, int[] seeds, int s) {
		
		if (seen[current]) {
			if (fields[current].type == 0) {
				// same

				if (seeds[fields[current].a] != s) return false;
			}
			else {
				// diff

				if (seeds[fields[current].a] == seeds[fields[current].b]) return false;
			}
		}

		seen[fields[current].a] = true;
		seen[fields[current].b] = true;

		if (fields[current].type == 0) {
			// same

			seeds[fields[current].a] = 1;
			seeds[fields[current].b] = 1;
		}
		else {
			// diff
			seeds[fields[current].a] = 1;
			seeds[fields[current].b] = 2;
		}

		return dfs(fields[current].a, fields, seeds, s);
	}

	static class Node {
		int a, b;
		int type = 0;

		Node (int a, int b, String type) {
			this.a = a;
			this.b = b;
			if (type.equals("D")) {
				this.type = 1;
			}
		}
	}
}