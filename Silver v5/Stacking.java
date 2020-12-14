import java.util.*;
import java.io.*;

public class Stacking {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("stacking.in")));
		PrintWriter out = new PrintWriter(new File("stacking.out"));

		int n = nextInt();
		int k = nextInt();

		Point[] points = new Point[k * 2];
		for (int i = 0; i < k; i++) {
			points[i * 2] = new Point(nextInt(), true);
			points[i * 2 + 1] = new Point(nextInt(), false);
		}

		Arrays.sort(points);

		int[] stack = new int[n];

		int pIndex = 0;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (points[pIndex].index == i) {
				if (points[pIndex].add) {
					counter++;

					stack[i] = counter;
				}
				else {
					stack[i] = counter;

					counter--;
				}
			}
			else {
				stack[i] = counter;
			}
		}

		Arrays.sort(stack);
		System.out.println(Arrays.toString(stack));

		out.println(stack[n / 2]);
		out.close();
	}

	static class Point implements Comparable<Point> {
		int index;
		boolean add;

		Point (int a, boolean b) {
			index = a;
			add = b;
		}

		public int compareTo(Point other) {
			if (index == other.index) return add ? -1 : 1;
			return Integer.compare(index, other.index);
		}
	}
}