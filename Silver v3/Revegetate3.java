import java.util.*;
import java.io.*;

public class Revegetate3 {
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

		for (int i = 0; i < n; i++) {
			fields[i] = new LinkedList<Edge>();
		}

		for (int i = 0; i < m; i++) {
			String type = next();
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			fields[a].add(new Edge(b, type));
			fields[b].add(new Edge(a, type));
		}

		int ans = 0;
		int[] seeds = new int[n];

		boolean ret = true;

		boolean[] seen = new boolean[n];
		
		for (int i = 0; i < fields.length; i++) {
			if (!seen[i]) {
				ret = ret && dfs(i, seen, fields, seeds, 0);
				ans++;
			}
		}

		StringBuilder str = new StringBuilder();

		str.append(1);

		for (int i = 0; i < ans; i++) {
			str.append(0);
		}

		if (ret) {
			out.println(str.toString());
		}
		else {
			out.println(0);
		}

		out.close();


	}

	static boolean dfs(int current, boolean[] seen, LinkedList<Edge>[] fields, int seeds[], int s) {
		if (seen[current]) {

			if (seeds[current] != s) return false;
			return true;
		}

		seeds[current] = s;
		seen[current] = true;

		boolean ret = true;

		for (Edge i : fields[current]) {

			if (i.type == 1) {
				ret = ret && dfs(i.neigh, seen, fields, seeds, s);
			}
			else {
				ret = ret && dfs(i.neigh, seen, fields, seeds, s * -1);
			}
		}

		return ret;
	}

	static class Edge {
		int neigh, type;

		Edge(int neigh, String val) {
			this.neigh = neigh;

			if (val.equals("D")) type = -1;
			else type = 1;
		}
	}
}