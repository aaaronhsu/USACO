import java.util.*;
import java.io.*;

public class Reststops2 {
	static StreamTokenizer in;

	static int f, b;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("reststops.in")));
		PrintWriter out = new PrintWriter(new File("reststops.out"));

		int l = nextInt();
		int n = nextInt();
		f = nextInt();
		b = nextInt();

		int[] stops = new int[l + 1];

		for (int i = 0; i < n; i++) {
			stops[nextInt()] = nextInt();
		}

		int currentMax = 0;
		TreeSet<Integer> rests = new TreeSet<>();

		for (int i = l; i >= 0; i--) {
			if (stops[i] > currentMax) {
				currentMax = stops[i];
				rests.add(i);
			}
		}

		int currentPosition = 0;
		long ans = 0;

		for (int i : rests) {
			ans += check(currentPosition, i, stops[i]);
			currentPosition = i;
		}

		out.println(ans);
		out.close();
	}

	static long check(int start, int end, int tasty) {
		long farmer = (long) (end - start) * f;
		long bessie = (long) (end - start) * b;

		return (farmer - bessie) * tasty;
	}
}