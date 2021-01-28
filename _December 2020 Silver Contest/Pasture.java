import java.util.*;
import java.io.*;

public class Pasture {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("pasture.in")));

		int n = nextInt();

		Point[] cows = new Point[n];
		for (int i = 0; i < n; i++) cows[i] = new Point(nextInt(), nextInt());

		Arrays.sort(cows);

		long ans = 1;
		for (int i = 0; i < n; i++) {
			int prevCows = 0;
			ans++;
			LinkedList<Integer> seenY = new LinkedList<>();

			for (int a = i + 1; a < n; a++) {

				int sub = check(cows[i].y, cows[a].y, seenY);
				seenY.add(cows[a].y);
				ans += 1 + prevCows - sub;
				prevCows++;
			}
		}

		System.out.println(ans);
	}

	static int check(int init, int val, LinkedList<Integer> seenY) {
		int ret = 0;

		for (int i : seenY) {
			if (init <= i && i <= val) ret++;
		}

		return ret;
	}

	static class Point implements Comparable<Point> {
		int x, y;

		Point (int a, int b) {
			x = a;
			y = b;
		}

		public int compareTo (Point other) {
			if (x == other.x) return Integer.compare(y, other.y);
			return Integer.compare(x, other.x);
		}
	}
}