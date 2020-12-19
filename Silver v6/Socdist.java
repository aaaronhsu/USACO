import java.util.*;
import java.io.*;

public class Socdist {
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

		for (int testC = 0; testC < 10; testC++) {
			in = new StreamTokenizer(new BufferedReader(new FileReader((testC + 1) + ".in")));
			PrintWriter out = new PrintWriter(new File("socdist.out"));

			int n = nextInt();
			int m = nextInt();

			Grass[] fields = new Grass[m];

			for (int i = 0; i < m; i++) fields[i] = new Grass(nextInt(), nextInt());
			Arrays.sort(fields);

			int low = 0;
			int high = fields[m - 1].end - fields[0].start + 1;

			while (high - low != 1) {
				int middle = (high + low) / 2;

				if (works(middle, fields, n)) low = middle;
				else high = middle;
			}

			int ans = -1;

			if (works(high, fields, n)) ans = high;
			else ans = low;

			Scanner checkAns = new Scanner(new File((testC + 1) + ".out"));

			if (ans == checkAns.nextInt()) System.out.println("Test case " + (testC + 1) + " passed");
			else System.out.println("Test case " + (testC + 1) + " failed");
		}
		
	}

	static boolean works(int dist, Grass[] fields, int cows) {
		int currentField = 0;
		int currentPos = fields[0].start;

		for (int i = 0; i < cows; i++) {
			while (!fields[currentField].contains(currentPos)) {
				currentField++;

				if (currentField == fields.length) return false;
				
				if (fields[currentField].start > currentPos) {
					currentPos = fields[currentField].start;
					break;
				}
			}

			currentPos += dist;
		}

		return true;
	}

	static class Grass implements Comparable<Grass> {
		int start, end;

		Grass (int a, int b) {
			start = a;
			end = b;
		}

		public boolean contains(int a) {
			return start <= a && a <= end;
		}

		public int compareTo(Grass other) {
			return Integer.compare(start, other.start);
		}
	}
}