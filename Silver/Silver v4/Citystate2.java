import java.util.*;
import java.io.*;

public class Citystate2 {
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

		HashMap<String, Integer> map = new HashMap<>();
		LinkedList<String> seen = new LinkedList<>();

		int asdf = 0;

		for (int i = 0; i < n; i++) {
			String a = next();
			String b = next();

			if (a.substring(0, 2).equals(b.substring(0, 2))) continue;

			String[] hold = new String[2];
			hold[0] = a;
			hold[1] = b;

			Arrays.sort(hold);

			String dup = a + b;
			String key = hold[0].substring(0, 2) + hold[1].substring(0, 2);

			if (!seen.contains(dup)) {
				if (map.containsKey(key)) {
					asdf++;
					map.put(key, map.get(key) + 1);
				}
				else map.put(key, 1);

				seen.add(dup);
			}
			
		}

		int ans = 0;

		for (String p : map.keySet()) {
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
}