import java.util.*;
import java.io.*;
import java.time.Year;

public class moop {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("moop.in")));
		PrintWriter out = new PrintWriter(new File("moop.out"));


		int cows = nextInt();

		int[] x = new int[cows];
		int[] y = new int[cows];

		for (int i = 0; i < cows; i++) {
			x[i] = nextInt();
			y[i] = nextInt();
		}

		LinkedList[] graph = new LinkedList[cows];
		for(int i = 0; i < cows; i++) graph[i] = new LinkedList<Integer>();

		for (int i = 0; i < cows; i++) {
			int currentX = x[i];
			int currentY = y[i];

			for (int j = i + 1; j < cows; j++) {
				if ((currentX >= x[j] && currentY >= y[j]) || (currentX <= x[j] && currentY <= y[j])) {
					graph[i].add(j);
					graph[j].add(i);

				}
			}
		}

		boolean[] visited = new boolean[cows];
		int ans = 0;

		for (int i = 0; i < cows; i++) {
			if (!visited[i]) {
				ans += dfs(graph, visited, i);
			}
		}

		out.println(ans);
		out.close();
	}

	static int dfs(LinkedList<Integer>[] graph, boolean[] visited, int start) {
		if (visited[start]) return 0;
		visited[start] = true;
		for(int neighbor : graph[start]) {
			dfs(graph, visited, neighbor);
		}

		return 1;
	}
}