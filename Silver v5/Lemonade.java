import java.util.*;
import java.io.*;

public class Lemonade {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("lemonade.in")));
		PrintWriter out = new PrintWriter(new File("lemonade.out"));

		int n = nextInt();
		int[] cows = new int[n];
		
		for (int i = 0; i < n; i++) cows[i] = nextInt();
		Arrays.sort(cows);

		for (int i = n - 1; i >= 0; i--) {
			if (cows[n - i + 1] < n - i + 2) {
				out.println(n - i + 2);
				out.close();
				break;
			}
		}
	}
}