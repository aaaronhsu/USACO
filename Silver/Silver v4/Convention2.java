import java.util.*;
import java.io.*;

public class Convention2 {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("convention2.in")));
		PrintWriter out = new PrintWriter(new File("convention2.out"));

		int n = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(nextInt(), nextInt(), i);
		}

		Arrays.sort(cows);

		int awef = 123;
	}

	static class Cow implements Comparable<Cow> {
		int time, length, seniority;

		Cow (int t, int l, int s) {
			time = t;
			length = l;
			seniority = s;
		}

		@Override // making sure that comparing the nodes compares values, not hash values
		public int compareTo(Cow other){
			if (time == other.time) return seniority - other.seniority;
			return time - other.time;
		}
	}
}