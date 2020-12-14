import java.util.*;
import java.io.*;

public class Div7 {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("div7.in")));
		PrintWriter out = new PrintWriter(new File("div7.out"));

		int n = nextInt();
		long[] prefix = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			prefix[i] = (prefix[i - 1] + nextInt()) % 7;
		}

		boolean good = false;

		for (int size = n; size >= 0; size--) {
			for (int i = 1; i < n - size + 1; i++) {
				System.out.println(i + ", " + (i + size));

				if (prefix[i + size] - prefix[i - 1] == 0) {
					good = true;
					out.println(size + 1);
					out.close();
				}

				if (good) break;
			}

			if (good) break;
		}

		if (!good) {
			out.println(0);
			out.close();
		}
	}
}