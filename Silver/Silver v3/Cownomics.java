import java.util.*;
import java.io.*;

public class Cownomics {
	static StreamTokenizer in;

	static int n, m;

	static String[] spotty;
	static String[] plain;

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
		in = new StreamTokenizer(new BufferedReader(new FileReader("cownomics.in")));
		PrintWriter out = new PrintWriter(new File("cownomics.out"));

		n = nextInt();
		m = nextInt();

		spotty = new String[n];
		plain = new String[n];

		for (int i = 0; i < n; i++) {
			spotty[i] = next();
		}

		for (int i = 0; i < n; i++) {
			plain[i] = next();
		}

		int low = 1;
		int high = m;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle)) high = middle;
			else low = middle;
		}

		if (works(low)) out.println(low);
		else out.println(high);

		out.close();
	}

	static boolean works(int size) {

		for (int i = 0; i < m - size + 1; i++) {
			HashSet<String> plainCow = new HashSet<>();
			int end = i + size;

			System.out.println(i + " " + end);

			for (int a = 0; a < n; a++) {
				plainCow.add(plain[a].substring(i, end));
			}


			boolean works = true;
			for (int a = 0; a < n; a++) {

				String test = spotty[a].substring(i, end);
				System.out.println(test);
				if (plainCow.contains(test)) {
					works = false;
					break;
				}
			}

			if (works) return true;
		}

		return false;
	}
}