import java.util.*;
import java.io.*;

public class Revegetate {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("revegetate.in")));
		PrintWriter out = new PrintWriter(new File("revegetate.out"));

		int n = nextInt();
		int m = nextInt();

		Field[] fields = new Field[n];
		int[] visited = new int[n];

		for (int i = 0; i < m; i++) {

			String type = next();
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			if (type.equals("S")) {
				fields[a] = new Field(b, 0);
				fields[b] = new Field(a, 0);
			}
			else {
				fields[a] = new Field(b, 1);
				fields[b] = new Field(a, 1);
			}
		}

		out.print(1);
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(fields, i, visited);
				out.print(0);
			}
		}

		out.println();
		out.close();


	}

	static void dfs(Field[] fields, int current, int[] visited) {
		if (visited[current] >= 1) return;

		visited[current] = 1;

		for (int i : fields[current].connect) {
			dfs(fields, i, visited);
		}
	}

	static class Field {
		int seed = -1;
		int type;

		LinkedList<Integer> connect = new LinkedList<>();

		Field(int connect, int type) {
			this.connect.add(connect);
			this.type = type;
		}
	}
}