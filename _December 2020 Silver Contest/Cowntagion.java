import java.util.*;
import java.io.*;

public class Cowntagion {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(System.in);
		
		int n = nextInt();

		LinkedList[] connections = new LinkedList[n];

		for (int i = 0; i < n; i++) connections[i] = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			connections[a].add(b);
			connections[b].add(a);
		}

		int ans = dfs(0, new boolean[n], connections, 1);
		double dup = (Math.log10(n) / Math.log10(2));

		if (dup - (int) dup != 0) ans += (int) dup + 1;
		else ans += dup;

		System.out.println(ans);
	}

	static int dfs(int index, boolean[] seen, LinkedList[] connections, int dist) {
		if (seen[index]) return 0;

		seen[index] = true;
		int ret = 0;

		for (int i : (LinkedList<Integer>) connections[index]) {

			if (!seen[i]) ret += dfs(i, seen, connections, dist + 1) + dist;
		}

		return ret;
	}
	
}