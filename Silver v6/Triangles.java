import java.util.*;
import java.io.*;

public class Triangles {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("triangles.in")));
		PrintWriter out = new PrintWriter(new File("triangles.out"));

		int n = nextInt();
		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			Point a = new Point(nextInt(), nextInt());

			 points[i] = a;
		}

		Arrays.sort(points, (Point a, Point b) -> {
			if (a.x == b.x) {
				return Integer.compare(a.y, b.y);
			}
			return Integer.compare(a.x, b.x);
		});

		ArrayList<Integer> distances = new ArrayList<>();
		int howManyMore = 0;

		for (int i = 0; i < n; i++) {
			if (howManyMore == 0) {
				distances = new ArrayList<>();
				int a = i + 1;
				if (a == n) break;
				while (points[i].x == points[a].x) {
					distances.add(points[a].y - points[a - 1].y);
					howManyMore++;
					a++;
					if (a == n) break;
				}

				int verticalSum = 0;
				for (int j = 0; j < distances.size(); j++) {
					verticalSum += distances.get(j) * (distances.size() - j);
				}

				points[i].verticalSum = verticalSum;
			}
			else {
				points[i].verticalSum = points[i - 1].verticalSum;
				int left = distances.size() + 1 - howManyMore;
				int right = howManyMore;

				points[i].verticalSum += distances.get(distances.size() - howManyMore) * left;
				points[i].verticalSum -= distances.get(distances.size() - howManyMore) * right;

				howManyMore--;
			}
		}

		Arrays.sort(points, (Point a, Point b) -> {
			if (a.y == b.y) {
				return Integer.compare(a.x, b.x);
			}
			return Integer.compare(a.y, b.y);
		});

		distances = new ArrayList<>();
		howManyMore = 0;

		for (int i = 0; i < n; i++) {
			if (howManyMore == 0) {
				distances = new ArrayList<>();
				int a = i + 1;
				if (a == n) break;
				while (points[i].y == points[a].y) {
					distances.add(points[a].x - points[a - 1].x);
					howManyMore++;
					a++;
					if (a == n) break;
				}

				int horizontalSum = 0;
				for (int j = 0; j < distances.size(); j++) {
					horizontalSum += distances.get(j) * (distances.size() - j);
				}

				points[i].horizontalSum = horizontalSum;
			}
			else {
				points[i].horizontalSum = points[i - 1].horizontalSum;
				int left = distances.size() + 1 - howManyMore;
				int right = howManyMore;

				points[i].horizontalSum += distances.get(distances.size() - howManyMore) * left;
				points[i].horizontalSum -= distances.get(distances.size() - howManyMore) * right;

				howManyMore--;
			}
		}

		System.out.println(10e8 + 7);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += points[i].horizontalSum * points[i].verticalSum;
			ans %= 10e8 + 7;
		}

		out.println(ans);
		out.close();


	}
	
	static class Point {
		int x, y;
		long horizontalSum, verticalSum;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + x + ", " + y + ") " + horizontalSum + " " + verticalSum;
		}
	}
}