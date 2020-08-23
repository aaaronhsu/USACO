import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

public class moocast {
	static StreamTokenizer in;
	static LinkedList[] reach;
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("moocast.in")));
		PrintWriter out = new PrintWriter(new File("moocast.out"));
		
		int n = nextInt();
		int[][] cows = new int[n][3];
		for (int i = 0; i < n; i++) {
			cows[i][0] = nextInt();
			cows[i][1] = nextInt();
			cows[i][2] = nextInt();
		}

		reach = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			reach[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < n; i++) {
			int x1 = cows[i][0];
			int y1 = cows[i][1];
			int rad = cows[i][2];

			for (int a = 0; a < n; a++) {
				if (Math.sqrt(Math.pow(cows[a][0] - x1, 2) + Math.pow(cows[a][1] - y1, 2)) <= rad) {
					reach[i].add(a);
					System.out.println("added " + a + " to " + i);
				}
			}
		}

		int ans = 1;

		for (int i = 0; i < n; i++) {
			int local = dfs(i, new HashSet<Integer>());

			if (local > ans) ans = local;
		}

		out.println(ans);
		out.close();
	}

	static int dfs(int node, HashSet<Integer> seen) {
		if (seen.contains(node)) return 0;
		seen.add(node);

		int count = 1;

		for (int i : (LinkedList<Integer>) reach[node]) {
			count += dfs(i, seen);
		}

		return count;
	}
}