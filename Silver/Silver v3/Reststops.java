import java.util.*;
import java.io.*;

public class Reststops {
	static StreamTokenizer in;

	static int l, n, f, b;	
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

		l = nextInt();
		n = nextInt();
		f = nextInt();
		b = nextInt();

		TreeMap<Integer, TreeSet<Integer>> stops = new TreeMap<>();

		int lastStop = 0;

		for (int i = 0; i < n; i++) { 
			int index = nextInt();
			int taste = nextInt();

			if (index > lastStop) lastStop = index;

			if (stops.get(taste) == null) {
				TreeSet<Integer> hold = new TreeSet<>();
				hold.add(index);
				stops.put(taste, hold);
			}
			else {
				stops.get(taste).add(index);
			}
		}

		long ans = 0;
		int index = 0;

		while (true) {

			int tasty = 0;
			int stop = 0;

			boolean found = false;
			while (!found) {
				for (int potTasty : stops.descendingKeySet()) {
					for (int potStop : stops.get(potTasty)) {
						if (potStop > index) {
							stop = potStop;
							tasty = potTasty;
							found = true;
						}

						if (found) break;
					}

					if (found) break;
				}
			}

			stops.get(tasty).remove(stop);

			ans += check(index, stop, tasty);

			System.out.println(index + " " + stop + " " + tasty);
			System.out.println(check(index, stop, tasty));

			System.out.println(" ");

			index = stop;

			if (index == lastStop) break;
		}

		out.println(ans);
		out.close();
	}

	static long check(int start, int end, int tasty) {
		long farmer = (end - start) * f;
		long bessie = (end - start) * b;

		System.out.println("farmer: " + farmer);
		System.out.println("bessie: " + bessie);

		return (farmer - bessie) * tasty;
	}
}