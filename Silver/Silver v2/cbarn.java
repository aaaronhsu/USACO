import java.util.*;
import java.io.*;

public class cbarn {
	static StreamTokenizer in;
	static int n;
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("cbarn.in")));
		PrintWriter out = new PrintWriter(new File("cbarn.out"));

		n = nextInt();

		int[] cows = new int[n];
		boolean[] filled = new boolean[n];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();
		}

		HashMap<Integer, Integer> collected = new HashMap<>();

		for (int i = 0; i < n; i++) {
			collected.put(i, 0);
		}

		System.out.println(collected);
		int energy = 0;
		int pointer = 0;
		while (!filled(filled)) {

			int holder = collected.get(0);
			for (int i = 1; i < n; i++) {
				int holder2 = collected.get(i);
				collected.put(i, holder);
				holder = holder2;
			}

			collected.put(0, cows[pointer]);
			cows[pointer] = 0;

			int dec = determineCow(collected);

			if (dec != -1 && !filled[pointer]) {
				collected.put(dec, collected.get(dec) - 1);
				energy += dec * dec;
				filled[pointer] = true;
			}



			pointer++;
			if (pointer == n) pointer = 0;
		}

		out.println(energy);
		out.close();
	}

	static boolean filled(boolean[] filled) {
		for (int i = 0; i < n; i++) {
			if (!filled[i]) return false;
		}
		return true;
	}

	static int[] addOne(int[] dist, int[] num) {
		for (int i = 0; i < n; i++) {
			if (num[i] != 0) dist[i]++;
		}

		return dist;
	}

	static int determineCow(HashMap<Integer, Integer> collected) {
		for (int i = n - 1; i >= 0; i--) {
			if (collected.get(i) != 0) return i;
		}
		return -1;
	}
}