import java.util.*;
import java.io.*;

public class Rut {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception {
		in.nextToken();
		return (String) in.sval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("rut.in")));
		
		int n = nextInt();

		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) cows[i] = new Cow(next(), nextInt(), nextInt());

		int[] interceptedBy = new int[n];
		int[] interceptionIndex = new int[n];
		Arrays.fill(interceptionIndex, -1);
		Arrays.fill(interceptedBy, -1);

		System.out.println(cows[4].intercepts(cows[2]));

		for (int i = 0; i < n; i++) {

			for (int a = 0; a < n; a++) {
				if (i == a) continue;

				if (cows[a].intercepts(cows[i])) {
					if (interceptionIndex[i] == -1 || cows[a].x < cows[interceptionIndex[i]].x) interceptedBy[i] = a;
				}
			}
		}

		System.out.println(Arrays.toString(interceptedBy));

		int[] ans = new int[n];

		for (int i = 0; i < n; i++) {
			if (interceptedBy[i] != -1) dfs(i, ans, interceptedBy);
		}

		for (int i = 0; i < n; i++) System.out.println(ans[i]);
	}

	static void dfs(int index, int[] ans, int[] interceptedBy) {
		if (interceptedBy[index] == -1) {
			ans[index]++;
			return;
		}

		dfs(interceptedBy[index], ans, interceptedBy);
	}

	static class Cow {
		String direction;
		int x, y;

		Cow(String a, int b, int c) {
			direction = a;
			x = b;
			y = c;
		}

		public boolean intercepts(Cow other) {
			if (direction.equals(other.direction)) {

				if (direction.equals("N")) {

					if (other.x == x) {
						return other.y < y;
					}
				}
				if (other.y == y) {
					return other.x < x;
				}
				return false;
			}

			// east is x, north is y

			if (direction.equals("N")) {
				// this cow is heading north, the other is going east
				if (other.x > x) return false;

				int yPos = y + (x - other.x);

				return y <= other.y && other.y < yPos;
			}
			else {
				// this cow is heading east, the other is going north
				if (x > other.x) return false;

				int yChange = other.x - x + other.y;

				if (yChange < y) return true;
				return false;
			}
			
		}
	}
}