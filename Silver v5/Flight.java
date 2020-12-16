import java.util.*;
import java.io.*;

public class Flight {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("input.txt"));

		int n = in.nextInt();
		int m = in.nextInt();

		LinkedList[] connections = new LinkedList[n];

		
		for (int i = 0; i < n; i++) connections[i] = new LinkedList<Integer>();
		for (int i = 0; i < m; i++) {
			connections[in.nextInt() - 1].add(in.nextInt() - 1);
		}

		for (int i = 0; i < n; i++) System.out.println(connections[i].toString());

		boolean bad = false;
		for (int i = 0; i < n; i++) {
			if (connections[i].size() == 0) {
				System.out.println("NO");
				System.out.println((i + 1) + " " + 1);
				bad = true;
				break;
			}
		}


		if (!bad) {
			boolean[] seen = new boolean[n];
			if (dfs(0, seen, connections) == n) System.out.println("YES");
			else {
				for (int i = 0; i < seen.length; i++) {
					if (!seen[i]) {
						System.out.println("NO");
						System.out.println(1 + " " + (i + 1));
						break;
					}
				}
			}
		}
	}

	static int dfs(int index, boolean[] seen, LinkedList[] connections) {
		if (seen[index]) return 0;

		int hold = 1;

		seen[index] = true;
		for (int i : (LinkedList<Integer>) connections[index]) {
			hold += dfs(i, seen, connections);
		}

		return hold;
	}
}