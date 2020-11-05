import java.util.*;
import java.io.*;

public class Rental {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("rental.in")));
		PrintWriter out = new PrintWriter(new File("rental.out"));

		int n, m, r;
		n = nextInt();
		m = nextInt();
		r = nextInt();

		int[] cows = new int[n];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();
		}

		Arrays.sort(cows);


		TreeMap<Integer, Integer> store = new TreeMap<>();

		for (int i = 0; i < m; i++) {
			int gal = nextInt();
			int price = nextInt();
			if (store.get(price) == null) {
				store.put(price, gal);
			}
			else {
				store.put(price, store.get(price) + gal);
			}
		}

		TreeSet<Integer> bulk = new TreeSet<>();

		for (int i = 0; i < r; i++) {
			bulk.add(nextInt());
		}

		long ans = 0;

		for (int i = n - 1; i >= 0; i--) {
			int sell = bulk.last();
			int market = 0;

			HashSet<Integer> removed = new HashSet<>();
			int[] updated = new int[2];

			int hold = 0;
			for (int price : store.descendingKeySet()) {
				if (hold + store.get(price) <= cows[i]) {
					market += price * store.get(price);
					hold += store.get(price);
					
					removed.add(price);
				}
				else {
					market += (cows[i] - hold) * price;
					updated[0] = price;
					updated[1] = store.get(price) - (cows[i] - hold);
					break;
				}
			}

			System.out.println(cows[i] + " could be milked for " + market);
			System.out.println(cows[i] + " could be sold for " + sell);
			
			if (market > sell) {

				System.out.println(cows[i] + " is milked to make " + market);
				for (int rem : removed) {
					store.remove(rem);
				}
				store.put(updated[0], updated[1]);

				ans += market;
			}
			else {
				System.out.println(cows[i] + " is sold to make " + sell);
				ans += bulk.pollLast();
			}
		}

		out.println(ans);
		out.close();
	}
}