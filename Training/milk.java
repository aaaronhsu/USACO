/*
ID: pufflew1
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;

public class milk {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("milk.in")));
		PrintWriter out = new PrintWriter(new File("milk.out"));

		int milk = nextInt();
		int f = nextInt();
		int ans = 0;

		HashMap<Integer, Integer> prices = new HashMap<>();
		int[] sale = new int[f];

		for (int i = 0; i < f; i++) {
			int price = nextInt();

			if (prices.get(price) != null) {
				prices.put(price, prices.get(price) + nextInt());
				sale[i] = Integer.MAX_VALUE;
			}
			else {
				prices.put(price, nextInt());
				sale[i] = price;
			}
			
		}

		Arrays.sort(sale);

		while (milk > 0) {
			for (int i = 0; i < f; i++) {
				int units = prices.get(sale[i]);

				if (milk - units >= 0) {
					ans += units * sale[i];
					milk -= units;
				}
				else {
					ans += milk * sale[i];
					milk = 0;
					break;
				}
			}
			
		}

		out.println(ans);
		out.close();


	}
}