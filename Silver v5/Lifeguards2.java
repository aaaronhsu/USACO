import java.util.*;
import java.io.*;

public class Lifeguards2 {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("lifeguards.in")));
		PrintWriter out = new PrintWriter(new File("lifeguards.out"));

		int n = nextInt();
		
		Point[] p = new Point[n * 2];

		for (int i = 0; i < n; i++) {
			p[i * 2] = new Point(nextInt(), i, true);
			p[i * 2 + 1] = new Point(nextInt(), i, false);
		}

		Arrays.sort(p);

		HashSet<Integer> working = new HashSet<>();
		int[] alone = new int[n];
		int together = 0;

		for (int i = 0; i < n * 2; i++) {
			
			if (working.size() == 1) {
				for (int a : working) {
					alone[a] += p[i].time - p[i - 1].time;
				}
			}
			if (working.size() >= 1) {
				together += p[i].time - p[i - 1].time; 
			}

			if (p[i].enter) {
				working.add(p[i].id);
			}
			else {
				working.remove(p[i].id);
			}
		}
		
		Arrays.sort(alone);

		out.println(together - alone[0]);
		out.close();
	}

	static class Point implements Comparable<Point> {
		int time, id;
		boolean enter;

		Point(int a, int b, boolean c) {
			time = a;
			id = b;
			enter = c;
		}

		public int compareTo(Point other) {
			return Integer.compare(this.time, other.time);
		}
	}
}