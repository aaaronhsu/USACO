import java.util.*;
import java.io.*;

public class Convention {
	static StreamTokenizer in;
	static int n, m, k;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("convention.in")));
		PrintWriter out = new PrintWriter(new File("convention.out"));

		n = nextInt();
		m = nextInt();
		k = nextInt();
		
		Integer[] cows = new Integer[n];
		for (int i = 0; i < n; i++) cows[i] = nextInt();
		Arrays.sort(cows);

		int low = 0;
		int high = cows[n - 1] - cows[0] + 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, cows)) high = middle;
			else low = middle;
		}

		if (works(low, cows)) out.println(low);
		else out.println(high);
		out.close();

	}

	static boolean works(int timeWait, Integer[] cows) {

		int curTime = timeWait + cows[0];
		int numBuses = 1;
		int numCows = 1;

		for (int i = 1; i < n; i++) {
			if (cows[i] > curTime || numCows == k) {
				curTime = timeWait + cows[i];
				numCows = 0;
				numBuses++;
			}

			numCows++;

			if (numBuses > m) return false;
		}


		return true;
	}
}