import java.util.*;
import java.io.*;

public class Rectangular {
	static StreamTokenizer in;

	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(System.in);

		int n = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Cow(nextInt(), nextInt());
		}

		// point compression
		Arrays.sort(cows, new Comparator<Cow>(){
			public int compare(Cow a, Cow b){
				return Integer.compare(a.x, b.x);
			}
		});

		for (int i = 0; i < n; i++) cows[i].x = i + 1;

		Arrays.sort(cows, new Comparator<Cow>(){
			public int compare(Cow a, Cow b){
				return Integer.compare(a.y, b.y);
			}
		});

		for (int i = 0; i < n; i++) cows[i].y = i + 1;


		// construct 2d psum
		int[][] board = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			board[cows[i].x][cows[i].y]++;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
			}
		}

		// calculate all possible combinations
		long ans = n + 1; // include subsets of size 1 and empty subset

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Cow one = cows[i];
				Cow two = cows[j];

				// determine bounds of rectangle
				int top = Integer.min(one.x, two.x);
				int bot = Integer.max(one.x, two.x);

				int left = Integer.min(one.y, two.y);
				int right = Integer.max(one.y, two.y);

				int lhs = board[bot][left] - board[top - 1][left - 1]; // number of cows to the left of the left-most cow (of Cow one and two)
				int rhs = board[bot][n] - board[bot][right - 1] - board[top - 1][n] + board[top - 1][right - 1]; // number of cows to the right of the right-most cow (of Cow one and two)

				ans += lhs * rhs; // sum the number of subsets that can be formed using Cow one and Cow two as corners
			}
		}

		System.out.println(ans);
	}

	static class Cow {
		int x, y;

		Cow (int a, int b) {
			x = a;
			y = b;
		}
	}
}
