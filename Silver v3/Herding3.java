import java.util.*;
import java.io.*;

public class Herding3 {
	static StreamTokenizer in;

	static int n;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("herding.in")));
		PrintWriter out = new PrintWriter(new File("herding.out"));

		n = nextInt();

		int[] cows = new int[n];
		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();
		}

		Arrays.sort(cows);

		int[] diff = new int[n - 1];

		for (int i = 1; i < n; i++) {
			diff[i - 1] = cows[i] - cows[i - 1] - 1;
		}

		int[] prefix = new int[n - 1];
		prefix[0] = diff[0];

		for (int i = 1; i < n - 1; i++) {
			prefix[i] = prefix[i - 1] + diff[i];
		}

		int low = 1;
		int high = n - 1;

		while (high - low != 1) {
			int middle = (low + high) / 2;

			if (works(middle, prefix)) low = middle;
			else high = middle;
		}

		int[] dup = diff.clone();
		Arrays.sort(dup);

		if (dup[dup.length - 2] == 0) {
			if (dup[dup.length - 1] == 1) {
				out.println(1);
			}
			else {
				out.println(2);
			}
		}
		else {
			if (works(high, prefix)) out.println(n - high - 1);
			else out.println(n - low - 1);
		}

		if (diff[0] > diff[diff.length - 1]) out.println(prefix[prefix.length - 2]);
		else out.println(prefix[prefix.length - 1] - prefix[0]);
		out.close();

	}

	static boolean works(int size, int[] prefix) {
		for (int i = size - 1; i < n - 1; i++) {
			if (determineSpaces(i - size + 1, i, prefix) <= n - (size + 1)) return true;
		}
		return false;
	}

	static int determineSpaces(int low, int high, int[] prefix) {
		if (low - 1 < 0) return prefix[high];
		else return prefix[high] - prefix[low - 1];
	}
}