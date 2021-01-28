import java.util.*;
import java.io.*;

public class Citystate {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("citystate.in")));
		PrintWriter out = new PrintWriter(new File("citystate.out"));

		int n = nextInt();

		HashMap<Place, Integer> map = new HashMap<>();

		int asdf = 0;

		for (int i = 0; i < n; i++) {
			String a = next();
			String b = next();

			Place p = new Place(a, b);

			if (map.containsKey(p)) {
				asdf++;
				map.put(p, map.get(p) + 1);
			}
			else map.put(p, 1);
		}

		int ans = 0;

		for (Place p : map.keySet()) {
			int hold = map.get(p);

			System.out.println(p + " has " + hold);
			if (hold == 1) continue;
			
			ans += (hold / 2) * hold;

			if (hold % 2 == 0) {
				System.out.println(n/2);
				ans -= hold/2;
			}
		}

		out.println(ans);
		out.close();
	}

	static int factorial(int n) {
		int fact = 1;
		int i = 1;

		while (i <= n) {
		   fact *= i;
		   i++;
		}

		return fact;
	}

	static class Place {
		String a, b;

		Place(String a, String b) {
			String[] hold = new String[2];
			hold[0] = a;
			hold[1] = b;

			Arrays.sort(hold);

			this.a = hold[0].substring(0, 2);
			this.b = hold[1].substring(0, 2);
		}

		public boolean equals(Object other) {
			return this.hashCode() == other.hashCode();
		}

		public int hashCode() {
			int hash = 0;

			String[] hold = {a, b};
			Arrays.sort(hold);

			hash += (int) hold[0].charAt(0);
			hash *= 100;
			hash += (int) hold[0].charAt(1);
			hash *= 100;
			hash += (int) hold[1].charAt(0);
			hash *= 100;
			hash += (int) hold[1].charAt(1);

			return hash;
		}
	}
}