import java.util.*;
import java.io.*;

public class Milkvisits {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("milkvisits.in")));
		PrintWriter out = new PrintWriter(new File("milkvisits.out"));

		int n = nextInt();
		int m = nextInt();

		LinkedList[] farms = new LinkedList[n];
		int[] milkType = new int[n]; // 1 is true, 0 is false
		
		String milkTypes = next();
		for (int i = 0; i < n; i++) {

			milkType[i] = milkTypes.charAt(i) == 'H' ? 1 : 0;

			farms[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int start = nextInt() - 1;
			int end = nextInt() - 1;

			farms[start].add(end);
			farms[end].add(start);
		}

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int start = nextInt() - 1;
			int end = nextInt() - 1;
			int milk = next().equals("H") ? 1 : 0;

			if (happy(start, end, farms, new boolean[n], milkType, milk, false)) str.append("1");
			else str.append("0");
		}

		out.println(str.toString());
		out.close();
	}

	static boolean happy(int index, int end, LinkedList[] farms, boolean[] visited, int[] milkType, int milkWant, boolean happy) {
		if (visited[index]) return false;

		visited[index] = true;

		if (milkType[index] == milkWant) happy = true;

		if (index == end) return happy || ;

		for (int i : (LinkedList<Integer>) farms[index]) {

			happy(i, end, farms, visited, milkType, milkWant, happy);
		}

		return true;

	}

}