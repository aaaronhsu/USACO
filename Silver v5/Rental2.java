import java.util.*;
import java.io.*;

public class Rental2 {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("rental.in")));
		PrintWriter out = new PrintWriter(new File("rental.out"));

		int n = nextInt();
		int m = nextInt();
		int k = nextInt();

		long[] milk = new long[n];
		Shop[] shops = new Shop[m];
		long[] rent = new long[k];

		for (int i = 0; i < n; i++) milk[i] = nextInt();

		for (int i = 0; i < m; i++) shops[i] = new Shop(nextInt(), nextInt());

		for (int i = 0; i < k; i++) rent[i] = nextInt();

		Arrays.sort(milk);
		Arrays.sort(shops);
		Arrays.sort(rent);

		long[] galPrefix = new long[n + 1];
		long[] rentPrefix = new long[k + 1];
		long[] milkPrefix = new long[n + 1];

		for (int i = 1; i < n + 1; i++) {
			galPrefix[i] = galPrefix[i - 1] + milk[n - i];
		}

		for (int i = 1; i < k + 1; i++) {
			rentPrefix[i] = rentPrefix[i - 1] + rent[k - i];
		}

		long[] forSaleCost = new long[m + 1];
		long[] forSale = new long[m + 1];

		for (int i = 1; i < m + 1; i++) {
			forSale[i] = forSale[i - 1] + shops[i - 1].gal;
			forSaleCost[i] = forSaleCost[i - 1] + (shops[i - 1].price * shops[i - 1].gal);
		}

		for (int i = 0; i < n + 1; i++) {
			int hold = Arrays.binarySearch(forSale, galPrefix[i]);

			if (hold >= 0) {
				milkPrefix[i] = forSaleCost[hold]; 
			} 
			else {
				hold *= -1;

				if (hold > m + 1) milkPrefix[i] = forSaleCost[forSaleCost.length - 1];
				else {

					long part1 = forSaleCost[hold - 2];
					long extraPrice = shops[hold - 2].price;
					long galsBuying = galPrefix[i] - forSale[hold - 2];
					milkPrefix[i] = part1 + (extraPrice * galsBuying);
				}
			}
		}

		long ans = 0;
		for (int i = 0; i < n + 1; i++) {
			if (i >= rentPrefix.length) {
				ans = Long.max(ans, rentPrefix[rentPrefix.length - 1] + milkPrefix[n - i]);
			}
			else ans = Long.max(ans, rentPrefix[i] + milkPrefix[n - i]);
		}

		out.println(ans);
		out.close();
	}

	static class Shop implements Comparable<Shop> {
		int gal, price;

		Shop (int a, int b) {
			gal = a;
			price = b;
		}

		public int compareTo(Shop other) {
			return Integer.compare(other.price, this.price);
		}

		public String toString() {
			return "This shop is buying " + gal + " milk for " + price + " each";
		}
	}
}