import java.util.*;
import java.io.*;

public class Bcount {
	static StreamTokenizer in;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("bcount.in")));
		PrintWriter out = new PrintWriter(new File("bcount.out"));

		int n = nextInt();
		int q = nextInt();

		int[] t1 = new int[n];
		int[] t2 = new int[n];
		int[] t3 = new int[n];

		for (int i = 0; i < n; i++) {
			int cow = nextInt();

			if (cow == 1) t1[i]++;
			else if (cow == 2) t2[i]++;
			else t3[i]++;
		}

		for (int i = 0; i < n - 1; i++) {
			t1[i + 1] = t1[i] + t1[i + 1];
			t2[i + 1] = t2[i] + t2[i + 1];
			t3[i + 1] = t3[i] + t3[i + 1];
		}

		for (int i = 0; i < q; i++) {
			int start = nextInt() - 1;
			int end = nextInt() - 1;

			if (start - 1 < 0) {
				out.println(t1[end] + " " + t2[end] + " " + t3[end]);
			}
			else {
				out.println((t1[end] - t1[start - 1]) + " " + (t2[end] - t2[start - 1]) + " " + (t3[end] - t3[start - 1]));
			}
		}
		out.close();
	}
}