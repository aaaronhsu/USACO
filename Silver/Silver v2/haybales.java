import java.util.*;
import java.io.*;

public class haybales {
	static StreamTokenizer in;
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("haybales.in")));
		PrintWriter out = new PrintWriter(new File("haybales.out"));

		int haybales = nextInt();
		int q = nextInt();

		int[] bales = new int[1000000000];

		for (int i = 0; i < haybales; i++) {
			bales[nextInt()]++;
		}

		int[] sum = new int[1000000001];

		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + bales[i - 1];
		}

		for (int i = 0; i < q; i++) {
			int start = nextInt();
			int end = nextInt();
			out.println(sum[end] - sum[start + 1]);
		}
		
		out.close();

	}

}