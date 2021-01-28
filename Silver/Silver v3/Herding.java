import java.util.*;
import java.io.*;

public class Herding {
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

		int min = 0;
		for (int i = 0; i < n; i++) {
			int hold = low(prefix, 0, i);

			if (hold > min) min = hold;
		}

		System.out.println(min);
	}

	static int low(int[] prefix, int target, int init) {
		int high = prefix.length - 1;
		int low = init;

		while (high - low != 1) {
			int middle = (high + low) / 2;
			target = n - (middle - target) + 1;

			if (det(init, middle, prefix) == target) return middle - init + 1;
			else if (det(init, middle, prefix) < target) low = middle;
			else high = middle;
		}

		if (det(init, high, prefix) > target) return low - init + 1;
		else return high - init + 1;
	}

	static int det(int low, int high, int[] prefix) {
		if (low - 1 < 0) return prefix[high];
		return prefix[high - (low - 1)];
	}
}