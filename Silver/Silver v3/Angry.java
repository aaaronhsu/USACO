import java.util.*;
import java.io.*;

public class Angry {
	static StreamTokenizer in;

	static int n, k;
	static int[] cows;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("angry.in")));
		PrintWriter out = new PrintWriter(new File("angry.out"));

		n = nextInt();
		k = nextInt();

		cows = new int[n];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();
		}

		Arrays.sort(cows);

		System.out.println(Arrays.toString(cows));

		int low = 1;
		int high = cows[n - 1] - cows[0];

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle)) high = middle;
			else low = middle;
		}

		if (works(low)) out.println(low);
		else out.println(high);

		out.close();
	}

	static boolean works(int range) {

		int pointer = 0;
		int currentDist = 0;

		for (int i = 0; i < k; i++) {

			currentDist = cows[pointer] + (range * 2);

			while (currentDist >= cows[pointer + 1]) {
				pointer++;
				if (pointer >= n - 1) return true;
			}

			pointer++;

		}

		if (currentDist >= cows[n - 1]) return true;
		return false;
	}
}