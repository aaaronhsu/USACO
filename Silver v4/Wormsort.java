import java.util.*;
import java.io.*;

public class Wormsort {
	static StreamTokenizer in;

	static int n, m;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("wormsort.in")));
		PrintWriter out = new PrintWriter(new File("wormsort.out"));

		n = nextInt();
		m = nextInt();

		int[] cows = new int[n];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt() - 1;
		}

		// creating components to see which cow needs to go where
		HashSet<HashSet<Integer>> cowComponents = new HashSet<>();

		boolean[] seen = new boolean[n];
		for (int i = 0; i < n; i++) {

			if (!seen[i]) {
				HashSet<Integer> hold = new HashSet<>();
				cowMovement(i, cows, seen, hold);
				if (hold.size() > 1) cowComponents.add(hold);
			}
		}
		
		// creating wormholes

		Wormhole[] wormholes = new Wormhole[m];
		for (int i = 0; i < m; i++) {
			wormholes[i] = new Wormhole(nextInt() - 1, nextInt() - 1, nextInt());
		}

		Arrays.sort(wormholes, (a,b) -> {
			return b.size - a.size;
		});



		int low = 0;
		int high = m - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;
			
			if (works(wormholes, middle, cowComponents)) high = middle;
			else low = middle;
		}

		if (low == 0 && works(wormholes, low, cowComponents)) out.println(-1);
		else if (works(wormholes, low, cowComponents)) out.println(wormholes[low].size);
		else out.println(wormholes[high].size);

		out.close();
	}

	static boolean works(Wormhole[] wormholes, int numWorm, HashSet<HashSet<Integer>> cowComponents) {
		HashSet[] connections = new HashSet[numWorm];

		for (int i = 0; i < numWorm; i++) {
			connections[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < numWorm; i++) {
			Wormhole hold = wormholes[i];

			connections[hold.p1].add(hold.p2);
			connections[hold.p2].add(hold.p1);
		}

		HashSet<HashSet<Integer>> wormComponents = new HashSet<>();
		boolean[] seen = new boolean[numWorm];
		for (int i = 0; i < n; i++) {

			if (!seen[i]) {
				HashSet<Integer> hold = new HashSet<>();

				dfs(i, connections, seen, hold);

				if (hold.size() > 1) wormComponents.add(hold);
			}
		}


		for (HashSet<Integer> cB : cowComponents) {

			boolean death = false;

			for (HashSet<Integer> wB : wormComponents) {

				boolean contains = true;
				for (int cS : cB) {

					if (!wB.contains(cS)) {
						contains = false;
						break;
					}

				}

				if (contains) {
					death = true;
					break;
				}
			}

			if (!death) return false;
		}

		return true;
	}

	static void dfs(int index, HashSet[] wormholes, boolean[] seen, HashSet<Integer> component) {
		if (seen[index]) return;

		seen[index] = true;

		component.add(index);

		for (int i : (HashSet<Integer>) wormholes[index]) {
			dfs(i, wormholes, seen, component);
		}
	}

	static void cowMovement(int index, int[] cows, boolean[] seen, HashSet<Integer> component) {
		if (seen[index]) return;
		seen[index] = true;
		component.add(index);
		cowMovement(cows[index], cows, seen, component);
	}

	static class Wormhole {
		int p1, p2, size;

		Wormhole(int p1, int p2, int size) {
			this.p1 = p1;
			this.p2 = p2;
			this.size = size;
		}

		public String toString() {
			return p1 + " to " + p2 + " with a size of " + size;
		}
	}	
}