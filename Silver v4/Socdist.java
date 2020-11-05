import java.util.*;
import java.io.*;

public class Socdist {
	static StreamTokenizer in;

	static int n, m;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("socdist.in")));
		PrintWriter out = new PrintWriter(new File("socdist.out"));

		n = nextInt();
		m = nextInt();

		Field[] fields = new Field[m];
		for (int i = 0; i < m; i++) {
			fields[i] = new Field(nextInt(), nextInt());
		}

		Arrays.sort(fields, (a, b) -> {
			return a.start - b.start;
		});

		int low = 1;
		int high = fields[m - 1].end - fields[0].start;
		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, fields)) low = middle;
			else high = middle;
		}

		if (works(high, fields)) out.println(high);
		else out.println(low);

		out.close();
	}

	static boolean works(int dist, Field[] fields) {

		int f = 0;
		int pos = fields[0].start;
		for (int i = 0; i < n; i++) {

			while(!fields[f].contain(pos)) {
				f++;
				if (f == fields.length) return false;
				if (pos < fields[f].start) pos = fields[f].start;
			}

			pos += dist;
		}

		return true;
	}

	static class Field {
		int start, end;
		
		Field(int a, int b) {
			start = a;
			end = b;
		}

		boolean contain(int a) {
			return start <= a && a <= end;
		}
	}
}