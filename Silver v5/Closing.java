import java.util.*;
import java.io.*;

public class Closing {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("closing.in")));
		PrintWriter out = new PrintWriter(new File("closing.out"));

		int n = nextInt();
		int m = nextInt();

		LinkedList[] farms = new LinkedList[n];
		HashSet<Integer> closed = new HashSet<>();

		for (int i = 0; i < n; i++) {
			farms[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			farms[a].add(b);
			farms[b].add(a);
		}

		boolean[] seen = new boolean[n];

		dfs(0, seen, closed, farms);

		if (check(seen, closed)) out.println("YES");
		else out.println("NO");

		for (int i = 0; i < n - 1; i++) {
			Arrays.fill(seen, false);
			closed.add(nextInt() - 1);

			for (int a = 0; a < n; a++) {
				if (!closed.contains(a)) {
					dfs(a, seen, closed, farms);
					break;
				}
			}

			if (check(seen, closed)) out.println("YES");
			else out.println("NO");
		}

		out.close();


	}

	static boolean check(boolean[] seen, HashSet<Integer> closed) {
		for (int i = 0; i < seen.length; i++) {
			if (closed.contains(i)) continue;
			if (!seen[i]) return false;
		}
		return true;
	}

	static void dfs(int index, boolean[] seen, HashSet<Integer> closed, LinkedList[] farms) {
		if (seen[index]) return;

		seen[index] = true;

		for (int i : (LinkedList<Integer>) farms[index]) {
			if (!closed.contains(i)) dfs(i, seen, closed, farms);
		}
	}
}