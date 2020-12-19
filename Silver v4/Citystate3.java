import java.util.*;
import java.io.*;

public class Citystate3 {
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

		for (int i = 0; i < n; i++) {
			String a = next();
			String b = next();

			String c = a.substring(0, 2);
			String d = b;

			if (!c.equals(d)) {
				if (map.containsKey(c + d)) {
					map.put(c + d, map.get(c + d) + 1);
				}
				else {
					map.put(c + d, 1);
				}
			}
		} 

		int ans = 0;

		for (String i : map.keySet()) {
			String other = i.substring(2) + i.substring(0, 2);

			if (map.keySet().contains(other)) ans += map.get(i) * map.get(other);
		}

		ans /= 2;

		out.println(ans);
		out.close();
	}
}