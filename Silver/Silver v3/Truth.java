import java.util.*;
import java.io.*;

public class Truth {
	static StreamTokenizer in;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("truth.in")));
		PrintWriter out = new PrintWriter(new File("truth.out"));

		int n = nextInt();
		int m = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow();
		}

		int ans = 0;
		
		for (int i = 0; i < m; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			String hold = next();
			int claim = 0;

			if (hold.equals("L")) {
				claim = -1;
			}
			else {
				claim = 1;
			}

			if (cows[a].val == 2) {
				claim *= -1;
			}

			if (claim > 0) {
				cows[a].truth.add(b);

				if (cows[b].val == 2) break;

				cows[b].val = 1;

				if (cows[b].lie.contains(a)) break;

				for (int e : cows[b].lie) {
					
				}
			}
			else {
				cows[a].lie.add(b);

				if (cows[b].val == 1) break;

				cows[a].val = 2;

				if (cows[b].truth.contains(a)) break;
			}

			ans++;
		}

		out.println(ans);
		out.close();
	}

	static class Cow {
		int val;

		HashSet<Integer> truth = new HashSet<>();
		HashSet<Integer> lie = new HashSet<>();
	}
}