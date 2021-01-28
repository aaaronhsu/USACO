import java.util.*;
import java.io.*;

public class Berries {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("berries.in")));
		PrintWriter out = new PrintWriter(new File("berries.out"));

		int n = nextInt();
		int k = nextInt();

		LinkedList<Integer> berries = new LinkedList<>();

		for (int i = 0; i < n; i++) berries.add(nextInt());
		Collections.sort(berries);
		
		while (berries.get(berries.size() - 1) != berries.get(berries.size() - (k / 2) - 1)) {
			int full = berries.get(berries.size() - 1) / berries.get(berries.size() - (k / 2) - 1);
			int part = berries.get(berries.size() - 1) % berries.get(berries.size() - (k / 2) - 1);
			
			int val = berries.get(berries.size() - (k / 2) - 1);

			int fullI = Collections.binarySearch(berries, val);
			int partI = Collections.binarySearch(berries, part);

			if (fullI < 0) fullI = (fullI * -1) - 1;
			if (partI < 0) partI = (partI * -1) - 1;

			
			for (int i = 0; i < full; i++) berries.add(fullI, val);
			berries.add(partI, part);

			berries.removeLast();
		}

		int ans = 0;
		for (int i = berries.size() - k; i < berries.size() - (k / 2); i++) {
			ans += berries.get(i);
		}

		out.println(ans);
		out.close();
	}
}