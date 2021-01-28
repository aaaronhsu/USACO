import java.util.*;
import java.io.*;

public class Cowntagion {
	static StreamTokenizer in;
	
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
		in = new StreamTokenizer(System.in);
		
		int n = nextInt();
		LinkedList[] connections = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			connections[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;
			connections[a].add(b);
			connections[b].add(a);
		}

		System.out.println(dfs(0, -1, connections));
	}

	static int dfs(int index, int parent, LinkedList[] connections) {
		
		int numChild = 0;
		for (int i : (LinkedList<Integer>) connections[index]) {
			if (i == parent) continue;
			numChild++;
		}

		if (numChild == 0) return 0;
		double result = Math.log(numChild) / Math.log(2);
		if (result == (int) result) result++;
		numChild += Math.ceil(result);

		for (int i : (LinkedList<Integer>) connections[index]) {
			if (i == parent) continue;
			numChild += dfs(i, index, connections);
		}

		return numChild;
	}
}