import java.util.*;
import java.io.*;

public class BuildingRoads {
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		LinkedList[] components = new LinkedList[n];

		for (int i = 0; i < n; i++) components[i] = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;

			components[a].add(b);
			components[b].add(a);
		}

		int ans = -1;
		LinkedList<Integer> roads = new LinkedList<>();
		boolean[] seen = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				roads.add(i);
				ans++;
				dfs(i, seen, components);
			}
		}

		System.out.println(ans);

		int hold = roads.getFirst() + 1;
		boolean first = true;
		for (int i : roads) {
			if (first) {
				first = false;
				continue;
			}

			System.out.println(hold + " " + (i + 1));
		}
		
	}

	static void dfs(int index, boolean[] seen, LinkedList[] components) {
		if (seen[index]) return;

		seen[index] = true;

		for (int i : (LinkedList<Integer>) components[index]) dfs(i, seen, components);
	}
}