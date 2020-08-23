import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.LinkedList;

public class planting {
	static StreamTokenizer in;
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static LinkedList<Integer>[] nodes;
	static int[] seed;

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("planting.in")));
		PrintWriter out = new PrintWriter(new File("planting.out"));

		int n = nextInt();

		nodes = new LinkedList[n];
		seed = new int[n];
		for (int i = 0; i < n; i++) nodes[i] = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			int start = nextInt() - 1;
			int end = nextInt() - 1;

			nodes[start].add(end);
			nodes[end].add(start);
		}

		dfs(0, -1);

		HashSet<Integer> ans = new HashSet<>();
		for (int i = 0; i < seed.length; i++) {
			ans.add(seed[i]);
		}

		out.println(ans.size());
		out.close();
	}

	static int determineSeed(int index) {
		LinkedList<Integer> neighSeeds = new LinkedList<>();
		for (int neigh : (LinkedList<Integer>) nodes[index]) {
			neighSeeds.add(seed[neigh]);

			for (int otherNeigh : (LinkedList<Integer>) nodes[neigh]) {
				neighSeeds.add(seed[otherNeigh]);
			}
		}

		for (int i = 1; i < 100000; i++) {
			if (!neighSeeds.contains(i)) return i;
		}

		return 0;
	}

	static void dfs(int node, int prev) {
		if (seed[node] != 0) return;

		seed[node] = determineSeed(node);
		for (int neigh : (LinkedList<Integer>) nodes[node]) {
			if (neigh == prev) continue;
			dfs(neigh, node);
		}
	}
}