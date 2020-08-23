import java.util.*;
import java.io.*;

public class closing {
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
			System.out.println(dfs(order.getFirst(), farms, order, new boolean[n]));
			System.out.println(order);

			LinkedList<Integer> holder = (LinkedList<Integer>)order.clone();
			Collections.sort(holder);

			LinkedList<Integer> asdf = dfs(order.getFirst(), farms, order, new boolean[n]);
			Collections.sort(asdf);

			if (asdf.equals(holder)) {
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

	static LinkedList<Integer> dfs(int node, LinkedList[] farms, LinkedList<Integer> allowed, boolean[] visited) {
		if (visited[node] || farms[node].size() == 0) return new LinkedList<Integer>();

		visited[node] = true;
		LinkedList<Integer> passed = new LinkedList<>();

		passed.add(node);

		for (int i : (LinkedList<Integer>)farms[node]) {
			passed.addAll(dfs(i, farms, allowed, visited));
		}

		return passed;
	}
}