import java.util.*;
import java.io.*;

public class Cowdance {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("cowdance.in")));
		PrintWriter out = new PrintWriter(new File("cowdance.out"));

		int n = nextInt();
		int t = nextInt();
		int[] cows = new int[n];
		for (int i = 0; i < n; i++) cows[i] = nextInt();

		int low = 1;
		int high = n;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, t, cows)) high = middle;
			else low = middle;
		}

		if (works(low, t, cows)) out.println(low);
		else out.println(high);
	}

	static boolean works(int k, int t, int[] cows) {
		int currentTime = 0;
		
		
	}
}