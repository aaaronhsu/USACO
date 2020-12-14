import java.util.*;
import java.io.*;

public class Rental {
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
		int r = nextInt();

		int[] cows = new int[n];
		Shop[] sell = new Shop[m];
		int[] rent = new int[r];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();
		}

		for (int i = 0; i < m; i++) {
			sell[i] = new Shop(nextInt(), nextInt());
		}

		for (int i = 0; i < r; i++) {
			rent[i] = nextInt();
		}

		Arrays.sort(cows);
		Arrays.sort(sell);
		Arrays.sort(rent);
		
		int money = 0;
		int currentShop = 0;
		int currentRent = r - 1;

		for (int i = n - 1; i >= 0; i--) {
			int pos = money(sell, currentShop, cows[i]);


			if (currentShop != m - 1 && currentRent != -1) {

				if (pos > rent[currentRent]) {
					money += pos;
	
					for (int a = currentShop; a < m; a++) {
						if (cows[i] > sell[a].gal) cows[i] -= sell[a].gal;
						else {
							sell[a].gal -= cows[i];
	
							currentShop = a;
							break;
						}
					}
				}
				else {
					money += rent[currentRent];
					currentRent--;
				}
			}
			else if (currentShop == m - 1 && currentRent == -1) {
				break;
			}
			else if (currentRent == -1) {
				money += pos;
	
					for (int a = currentShop; a < m; a++) {
						if (cows[i] > sell[a].gal) cows[i] -= sell[a].gal;
						else {
							sell[a].gal -= cows[i];
	
							currentShop = a;
							break;
						}
					}
			}
			else {
				money += rent[currentRent];
				currentRent--;
			}
		}

		
		out.println(money);
		out.close();



	}

	static int money(Shop[] shops, int currentShop, int gal) {
		int ret = 0;

		for (int i = currentShop; i < shops.length; i++) {
			if (gal > shops[currentShop].gal) {
				ret += shops[currentShop].gal * shops[currentShop].price;
				gal -= shops[currentShop].gal;
			}

			if (gal < shops[currentShop].gal) {
				ret += gal * shops[currentShop].price;
				break;
			}
		}

		return ret;
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
	}

}