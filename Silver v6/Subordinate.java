import java.util.*;
import java.io.*;

public class Subordinate {
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

		for (int i = 1; i < n; i++) {
			connections[nextInt() - 1].add(i);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(dfs(i, connections) - 1);
		}
	}

	static int dfs(int index, LinkedList[] tree) {

		int ret = 1;

		for (int i : (LinkedList<Integer>) tree[index]) {
			ret += dfs(i, tree);
		}

		return ret;
	}
}