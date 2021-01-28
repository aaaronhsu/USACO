import java.util.*;
import java.io.*;

public class closing2 {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("closing.in")));
		PrintWriter out = new PrintWriter(new File("closing.out"));

		int n = nextInt();

		LinkedList[] farms = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			farms[i] = new LinkedList<Integer>();
		}

		int m = nextInt();

		for (int i = 0; i < m; i++) {
			int from = nextInt() - 1;
			int to = nextInt() - 1;

			farms[from].add(to);
			farms[to].add(from);
		}

		LinkedList<Integer> order = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			order.add(nextInt() - 1);
		}


		for (int i = 0; i < n; i++) {

			LinkedList<Integer> holder = (LinkedList<Integer>)order.clone();
			Collections.sort(holder);

			boolean[] visited = new boolean[n];
			dfs(order.getFirst(), farms, order, visited);
			
			LinkedList<Integer> compare = new LinkedList<>();

			for (int a = 0; a < n; a++) {
				if (visited[a]) {
					compare.add(a);
				}
			}
			Collections.sort(compare);

			if (compare.equals(holder)) {
				out.println("YES");
			}
			else {
				out.println("NO");
			}

			int removedFarm = order.pop();

			farms[removedFarm] = new LinkedList<Integer>();
		}

		out.close();

		
	}

	static void dfs(int node, LinkedList[] farms, LinkedList<Integer> allowed, boolean[] visited) {
		if (visited[node] || farms[node].size() == 0) return;

		visited[node] = true;
		LinkedList<Integer> passed = new LinkedList<>();

		passed.add(node);

		for (int i : (LinkedList<Integer>)farms[node]) {
			dfs(i, farms, allowed, visited);
		}
	}
}