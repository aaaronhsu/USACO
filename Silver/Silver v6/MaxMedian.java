import java.util.*;
import java.io.*;

public class MaxMedian {
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
		int k = nextInt();

		Integer[] asdf = new Integer[n];
		for (int i = 0; i < n; i++) asdf[i] = nextInt();

		Arrays.sort(asdf);

		LinkedList<Integer> incr = new LinkedList<>();
		int hold = asdf[n / 2];
		for (int i = n / 2 + 1; i < n; i++) {
			incr.add(asdf[i] - hold);
		}

		int ans = 0;
		int increment = 1;

		while (k - increment >= 0) {
			while (incr.size() != 0 && ans == incr.getFirst()) {
				increment++;
				incr.poll();
			}

			if (k >= 0) {
				ans++;
				k -= increment;
			}
		}

		System.out.println(ans + hold);



	}
}