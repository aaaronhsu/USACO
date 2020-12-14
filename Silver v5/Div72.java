import java.util.*;
import java.io.*;

public class Div72 {
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

		int[] first = new int[7];

		Arrays.fill(first, Integer.MAX_VALUE);
		
		int[] last = new int[7];

		int currentPrefix = 0;

		for (int i = 0; i < n; i++) {
			currentPrefix += nextInt();
			currentPrefix %= 7;

			first[currentPrefix] = Integer.min(first[currentPrefix], i);
			last[currentPrefix] = Integer.max(last[currentPrefix], i);
		}


		int ans = 0;

		for (int i = 0; i < 7; i++) {
			ans = Integer.max(ans, last[i] - first[i]);
		}

		out.println(ans);
		out.close();

	}
}