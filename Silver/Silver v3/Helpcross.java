import java.util.*;
import java.io.*;

public class Helpcross {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("helpcross.in")));
		PrintWriter out = new PrintWriter(new File("helpcross.out"));

		int c = nextInt();
		int n = nextInt();

		int[] chickens = new int[c];

		for (int i = 0; i < c; i++) {
			chickens[i] = nextInt();
		}

		Arrays.sort(chickens);

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			int start = nextInt();
			int end = nextInt();

			cows[i] = new Cow(start, end, high(chickens, end) - low(chickens, start));
		}

		Arrays.sort(cows, (a, b) -> {
			if (a.a == b.a) return a.b - b.b;
			return a.a - b.a;
		});
		

		int maxCow = Integer.MAX_VALUE;
		int cowIndex = -1;

		int ans = 0;

		for (int i = 0; i < c; i++) {
			for (int a = 0; a < n; a++) {
				if (chickens[i] >= cows[a].a && chickens[i] <= cows[a].b) {
					if (cows[a].n < maxCow && cows[a].n != 0) {
						maxCow = cows[a].n;
						cowIndex = a;
					}
				}

				if (chickens[i] < cows[a].a) break;
			}

			if (maxCow != Integer.MAX_VALUE) {
				ans++;
				cows[cowIndex].n = 0;
				maxCow = Integer.MAX_VALUE;
				cowIndex = -1;
			}
		}

		out.println(ans);
		out.close();


	}

	static int low(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return middle - 1;
			else if (arr[middle] > target) high = middle;
			else low = middle;
		}

		if (arr[high] == target) return high;
		else return low;
	}

	static int high(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return middle + 1;
			else if (arr[middle] > target) high = middle;
			else low = middle;
		}

		if (arr[low] == target) return low;
		else return high;
	}

	static class Cow {
		int a, b;
		int n;

		Cow(int a, int b) {
			this.a = a;
			this.b = b;
		}

		Cow(int a, int b, int n) {
			this.a = a;
			this.b = b;
			this.n = n;
		}

		void set(int n) {
			this.n = n;
		}
	}
}