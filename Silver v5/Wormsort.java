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
		for (int i = 0; i < n; i++) cows[i] = nextInt() - 1;

		Wormhole[] wormholes = new Wormhole[m];
		for (int i = 0; i < m; i++) wormholes[i] = new Wormhole(nextInt(), nextInt(), nextInt());

		Arrays.sort(wormholes);

		HashSet<HashSet<Integer>> cowComponents = new HashSet<>();
		boolean[] seen = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				HashSet<Integer> hold = new HashSet<>();

				cowDfs(i, seen, cows, hold);
				if (hold.size() != 1) cowComponents.add(hold);
			}
		}

		int low = 0;
		int high = m - 1;

		if (works(0, cowComponents, wormholes)) {
			out.println(-1);
		}
		else {
			while (high - low != 1) {
				int middle = (high + low) / 2;
				
				if (works(middle, cowComponents, wormholes)) high = middle;
				else low = middle;
			}
		
			if (works(low, cowComponents, wormholes)) out.println(wormholes[low - 1].size);
			else out.println(wormholes[high - 1].size);
		}

		

		out.close();

	}

	static boolean works(int numWormholes, HashSet<HashSet<Integer>> cowComponents, Wormhole[] wormholes) {

		LinkedList[] cowConnections = new LinkedList[n];
		for (int i = 0; i < n; i++) cowConnections[i] = new LinkedList<Integer>();
		for (int i = 0; i < numWormholes; i++) {
			cowConnections[wormholes[i].a].add(wormholes[i].b);
			cowConnections[wormholes[i].b].add(wormholes[i].a);
		}

		HashSet<HashSet<Integer>> holeComponents = new HashSet<>();
		boolean[] seen = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				HashSet<Integer> hold = new HashSet<>();

				holeDfs(i, cowConnections, seen, hold);
				if (hold.size() != 1) holeComponents.add(hold);
			}
		}

		for (HashSet<Integer> cowComponent : cowComponents) {
			boolean works = false;

			for (HashSet<Integer> holeComponent : holeComponents) {
				boolean again = false;

				for (int cow : cowComponent) {
					if (!holeComponent.contains(cow)) {
						again = true;
						break;
					}
				}

				if (again) continue;

				works = true;
				break;
			}

			if (!works) return false;
		}

		return true;
	}

	static void holeDfs(int index, LinkedList[] connections, boolean[] seen, HashSet<Integer> hold) {
		if (index >= seen.length || seen[index]) return;
		seen[index] = true;

		hold.add(index);

		for (int i : (LinkedList<Integer>) connections[index]) {
			holeDfs(i, connections, seen, hold);
		}
	}

	static void cowDfs(int index, boolean[] seen, int[] cows, HashSet<Integer> hold) {
		if (seen[index]) return;
		seen[index] = true;

		hold.add(index);

		cowDfs(cows[index], seen, cows, hold);
	}

	static class Wormhole implements Comparable<Wormhole> {
		int a, b, size;

		Wormhole (int q, int w, int e) {
			a = q - 1;
			b = w - 1;
			size = e;
		}

		public int compareTo (Wormhole other) {
			return Integer.compare(other.size, size);
		}
	}
}