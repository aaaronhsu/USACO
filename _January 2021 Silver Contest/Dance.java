import java.util.*;
import java.io.*;

public class Dance {
	static StreamTokenizer in;
	static boolean[] visited;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(System.in);

		int n = nextInt();
		int[] places = new int[n];
		HashSet[] oneCycle = new HashSet[n]; // better because unordered and fast





		// p1
		for (int i = 0; i < n; i++) {
			places[i] = i; // each cow starts at respective position

			oneCycle[i] = new HashSet<Integer>();
			oneCycle[i].add(i);
		}

		int k = nextInt();
		for (int i = 0; i < k; i++) {
			int p1 = nextInt() - 1;
			int p2 = nextInt() - 1;

			int swap = places[p2];

			places[p2] = places[p1];
			places[p1] = swap;

			oneCycle[places[p1]].add(p1);
			oneCycle[places[p2]].add(p2);

		}





		// p2
		int[] ans = new int[n];
		visited = new boolean[n]; // ff to find cycles

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				ArrayList<Integer> connections = new ArrayList<Integer>();
				cycle(i, places, connections);

				// creates connections
				HashSet<Integer> totP = new HashSet<>(); // all places these cows will be, hset for no dup

				for (int a : connections) {
					for (int j : (HashSet<Integer>) oneCycle[a]) totP.add(j);
				}

				for (int a : connections) ans[a] = totP.size();

			}
		}


		for (int i : ans) System.out.println(i);
	}

	static void cycle(int position, int[] positions, ArrayList<Integer> connections) {
		if (visited[position]) return;
		visited[position] = true;
		connections.add(position);

		cycle(positions[position], positions, connections);
	}
}