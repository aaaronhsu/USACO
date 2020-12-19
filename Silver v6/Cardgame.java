import java.util.*;
import java.io.*;

public class Cardgame {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("cardgame.in")));
		PrintWriter out = new PrintWriter(new File("cardgame.out"));

		int n = nextInt();
		boolean[] e = new boolean[n * 2];
		int[] elsie = new int[n];

		LinkedList<Integer> b1 = new LinkedList<>();
		LinkedList<Integer> b2 = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int hold = nextInt();
			e[hold - 1] = true;
			elsie[i] = hold;
		}

		int index = 0;
		for (int i = 0; i < n * 2; i++) {
			if (!e[i]) {
				if (index < n / 2) b1.add(i + 1);
				else b2.add(i + 1);

				index++;
			}
		}

		int ans = 0;

		for (int i = 0; i < n; i++) {

			if (i < n / 2) {
				int cardPlayed = Collections.binarySearch(b2, elsie[i]) * -1 - 1;

				if (cardPlayed > b2.size() - 1) {
					b2.remove(0);
					continue;
				}

				if (b2.get(cardPlayed) > elsie[i]) {
					ans++;
				}

				b2.remove(cardPlayed);
			}
			else {
				int cardPlayed = Collections.binarySearch(b1, elsie[i]) * -1 - 2;

				if (cardPlayed < 0) {
					b1.remove(b1.size() - 1);
					continue;
				}

				if (b1.get(cardPlayed) < elsie[i]) {
					ans++;
				}

				b1.remove(cardPlayed);
			}
			
		}

		out.println(ans);
		out.close();
	}
}