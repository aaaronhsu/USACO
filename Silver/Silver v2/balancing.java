import java.util.*;
import java.io.*;

public class balancing2 {
	static StreamTokenizer in;

	static int n;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("balancing.in")));
		PrintWriter out = new PrintWriter(new File("balancing.out"));

		n = nextInt();

		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			points[i] = new Point(nextInt(), nextInt());
		}


		// get X
		Arrays.sort(points, (a,b) -> {
			if (a.x == b.x) return a.y - b.y;
			return a.x - b.x;
		});

		int[] x = new int[2];
		// even
		if (n % 2 == 0) {
			x[0] = (points[(n / 2) - 1].x + points[(n / 2)].x) / 2;
			x[1] = (points[(n / 2) - 1].x + points[(n / 2)].x) / 2;
		}
		// odd
		else {
			x[0] = points[n / 2].x - 1;
			x[1] = points[n / 2].x + 1;
		}

		System.out.println(x[0]);
		System.out.println(x[1]);


		// get Y
		Arrays.sort(points, (a,b) -> {
			if (a.y == b.y) return a.x - b.x;
			return a.y - b.y;
		});

		for (int i = 0; i < n; i++) {
			System.out.println(points[i].print());
		}

		int[] y = new int[2];

		// even
		if (n % 2 == 0) {
			y[0] = (points[(n / 2) - 1].y + points[(n / 2)].y) / 2;
			y[1] = (points[(n / 2) - 1].y + points[(n / 2)].y) / 2;
		}
		// odd
		else {
			y[0] = points[n / 2].y - 1;
			y[1] = points[n / 2].y + 1;
		}


		System.out.println(y[0]);
		System.out.println(y[1]);



		int currentMin = Integer.MAX_VALUE;

		for (int i = 0; i < 2; i++) {
			for (int a = 0; a < 2; a++) {
				int holder = determine(points, x[i], y[a]);

				if (holder < currentMin) currentMin = holder;
			}
		}

		out.println(currentMin);
		out.close();
	}

	static int determine(Point[] points, int x, int y) {
		int currentMax = -1;
		int holder = 0;
		
		for (int i = 0; i < n; i++) {
			if (points[i].x < x && points[i].y < y) holder++;
		}
		if (holder > currentMax) currentMax = holder;
		
		holder = 0;

		for (int i = 0; i < n; i++) {
			if (points[i].x > x && points[i].y < y) holder++;
		}
		if (holder > currentMax) currentMax = holder;
		
		holder = 0;
		
		for (int i = 0; i < n; i++) {
			if (points[i].x < x && points[i].y > y) holder++;
		}
		if (holder > currentMax) currentMax = holder;
		
		holder = 0;
		
		for (int i = 0; i < n; i++) {
			if (points[i].x > x && points[i].y > y) holder++;
		}
		if (holder > currentMax) currentMax = holder;

		return currentMax;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		String print() {
			return x + " " + y;
		}
	}
}