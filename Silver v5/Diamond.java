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
		for (int i = 0; i < n; i++) diamonds[i] = nextInt();
		Arrays.sort(diamonds);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			int hold = Arrays.binarySearch(diamonds, diamonds[i] + k);

			if (hold < 0) ans = Integer.max(ans, (hold * -1) - i + 1);
			else ans = Integer.max(ans, hold - i + 1);
		}

		out.println(ans);
		out.close();
	}
}