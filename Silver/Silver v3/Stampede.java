import java.util.*;
import java.io.*;

public class Stampede {
	static StreamTokenizer in;
	
	static int n, l;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("stampede.in")));
		PrintWriter out = new PrintWriter(new File("stampede.out"));

		n = nextInt();

		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			int a = nextInt();
			int b = nextInt();
			int c = nextInt();

			int start = a * c * -1;
			int end = (a + 1) * c * -1;

			cows[i] = new Cow(start, end, b);
		}

		Arrays.sort(cows, (a,b)-> {
			return a.pos - b.pos;
		});

		for (int i = 0; i < n; i++) {
			System.out.println(cows[i].pos);
		}

		LinkedList<Restriction> rest = new LinkedList<>();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			boolean add = true;
			for (Restriction a : rest) {
				if (a.check(cows[i].start, cows[i].end)) {
					add = false;
					break;
				}
			}

			if (add) {
				ans++;
				rest.add(new Restriction(cows[i].start, cows[i].end));
			}
		}

		for (Restriction i : rest) {
			i.print();
		}


		out.println(ans);
		out.close();


		
	}

	static class Cow {
		int start, end, pos;

		Cow (int a, int b, int c) {
			start = a;
			end = b;
			pos = c;
		}
	}

	static class Restriction {
		int start, end;

		boolean check (int a, int b) {
			if (b < end && a > start) return false;
			return true;
		}

		void print() {
			System.out.println(start + " " + end);
		}
		Restriction(int a , int b) {
			start = b;
			end = a;
		}
	}
}