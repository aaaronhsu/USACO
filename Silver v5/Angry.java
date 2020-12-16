import java.util.*;
import java.io.*;

public class Angry {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("angry.in")));
		PrintWriter out = new PrintWriter(new File("angry.out"));

		int n = nextInt();
		int k = nextInt();

		int[] cows = new int[n];
		for (int i = 0; i < n; i++) cows[i] = nextInt();
		Arrays.sort(cows);

		int low = 0;
		int high = 1000000000;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, cows, k)) high = middle;
			else low = middle;
		}

		if (works(low, cows, k)) out.println(low);
		else out.println(high);

		out.close();
	}

	static boolean works(int power, int[] cows, int numCows) {
		int curBlast = 0;
		int curIndex = 0;
		int cowsUsed = 0;
		while (curIndex < cows.length) {
			if (curBlast < cows[curIndex]) {
				curBlast = cows[curIndex] + (power * 2);
				cowsUsed++;
			}

			curIndex++;

			if (cowsUsed > numCows) return false;
		}

		return true;
	}
}