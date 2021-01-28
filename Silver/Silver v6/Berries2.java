import java.util.*;
import java.io.*;

public class Berries2 {
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
		
		Integer[] init = new Integer[n];

		for (int i = 0; i < n; i++) init[i] = nextInt();
		Arrays.sort(init);

		LinkedList<Integer> berries = new LinkedList<>();

		for (int i = n - k; i < n; i++) berries.add(init[i]);


		while ((berries.get(berries.size() - 1) / 2) + (berries.get(berries.size() - 1) % 2) > berries.get(0)) {
			System.out.println(berries.toString());
			int hold = berries.pollLast();

			Integer[] compare = new Integer[4];

			compare[0] = (hold / 2) + (hold % 2);
			compare[1] = hold / 2;
			compare[2] = berries.pollFirst();
			compare[3] = berries.pollFirst();

			Arrays.sort(compare);

			berries.add(compare[1]);
			berries.add(compare[2]);
			berries.add(compare[3]);

			Collections.sort(berries);
		}

		int ans = 0;
		for (int i = 0; i < k / 2; i++) ans += berries.pollFirst();

		out.println(ans);
		out.close();
	}
}