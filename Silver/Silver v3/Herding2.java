import java.util.*;
import java.io.*;

public class Herding2 {
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


		int low = 0;
		int high = n - 2;

		while (high - low != 1) {
			int middle = (high + low) / 2;
			System.out.println(middle);
			if (works(middle, prefix)) low = middle;
			else high = middle;
		}

		if (works(high, prefix)) System.out.println(n - (high + 1));
		else System.out.println(n - (low + 1));



	}

	static boolean works(int size, int[] prefix) {
		for (int i = size - 1; i < n - 1; i++) {
			if (det(i - size + 1, i, prefix) <= n - (size + 1)) return true;
		}
		return false;
	}

	static int det(int low, int high, int[] prefix) {
		// System.out.println(low + " " + high);
		if (low - 1 < 0) return prefix[high];
		return prefix[high] - prefix[low - 1];
	}
}