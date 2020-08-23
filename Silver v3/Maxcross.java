import java.util.*;
import java.io.*;

public class Maxcross {
	static StreamTokenizer in;
	static int n, k, b;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("maxcross.in")));
		PrintWriter out = new PrintWriter(new File("maxcross.out"));

		n = nextInt();
		k = nextInt();
		b = nextInt();

		int[] cows = new int[b + 2];
		cows[b + 1] = 1;
		cows[b] = n;

		for (int i = 0; i < b; i++) {
			cows[i] = nextInt();
		}

		Arrays.sort(cows);

		int[] prefix = new int[b + 1];

		for (int i = 0; i < b + 1; i++) {
			prefix[i] = cows[i + 1] - cows[i] - 1;
		}


		System.out.println(Arrays.toString(cows));
		System.out.println(Arrays.toString(prefix));


		int ans = -1;
		boolean getMeOut = false;

		for (int i = 0; i < b + 1; i++) {
			if (i == 0) {
				for (int a = 0; a < b + 1; a++) {
					if (prefix[a] >= k) {
						ans = 1;
						getMeOut = true;
					}
				}
			}
			else if (i == 1) continue;
			else if (works(i, prefix)) {
				ans = i;
				break;
			}

			if (getMeOut) break;
		}

		out.println(ans);
		out.close();
	}

	static boolean works(int range, int[] prefix) {
		for (int i = range; i < b + 1; i++) {
			if (i - range < 0) {
				if (prefix[i] + range >= k) return true;
			}
			else if (prefix[i] - prefix[i - range] + range >= k) return true;
		}

		return false;
	}
}