import java.util.*;
import java.io.*;

public class CellularNetwork {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
		PrintWriter out = new PrintWriter(new File("output.txt"));

		int n = nextInt();
		int m = nextInt();

		TreeSet<Integer> cities = new TreeSet<>();
		TreeSet<Integer> towers = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			cities.add(nextInt());
		}

		for (int i = 0; i < m; i++) {
			towers.add(nextInt());
		}

		int low = 0;
		int high = cities.last() - cities.first() + 1;
		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, cities, towers)) high = middle;
			else low = middle;
		}

		if (works(low, cities, towers)) out.println(low);
		else out.println(high);

		out.close();
	}

	static boolean works(int r, TreeSet<Integer> cities, TreeSet<Integer> towers) {
		for (int city : cities) {
			String low = "" + towers.lower(city);
			String high = "" + towers.higher(city);

			int minDist = Integer.MAX_VALUE;
			if (!low.equals("null")) {
				minDist = (city - Integer.parseInt(low)) < minDist ? (city - Integer.parseInt(low)) : minDist;
			}

			if (!high.equals("null")) {
				minDist = (Integer.parseInt(high) - city) < minDist ? (Integer.parseInt(high) - city) : minDist;
			}

			if (minDist > r) return false;
		}

		return true;
	}


}