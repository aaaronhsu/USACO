import java.util.*;
import java.io.*;

public class Diamond {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("diamond.in")));
		PrintWriter out = new PrintWriter(new File("diamond.out"));

		int n = nextInt();
		int k = nextInt();

		int[] diamonds = new int[n];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) diamonds[i] = nextInt();
		Arrays.sort(diamonds);

		int ans = 0;

		// find first

		int[] precompute = new int[n];

		for (int i = 0; i < n; i++) {
			map.put(diamonds[i], i);
		}

		for (int i = 0; i < n; i++) {
			int endIndex = Arrays.binarySearch(diamonds, diamonds[i] + k);

			if (endIndex < 0) {
				endIndex *= -1;
				endIndex -= 2;
			}

			precompute[i] = map.get(diamonds[endIndex]);
		}

		for (int i = 0; i < n; i++) {
			int fHalf = precompute[i] - i + 1;
			int lHalf = -1;

			for (int a = precompute[i] + 1; a < n; a++) {
				lHalf = Integer.max(lHalf, precompute[a] - a + 1);
			}

			ans = Integer.max(ans, fHalf + lHalf);
		}

		out.println(ans);
		out.close();

	}
}