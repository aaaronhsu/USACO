import java.util.*;
import java.io.*;

public class Stacking2 {
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

		int[] posChange = new int[n];
		int[] negChange = new int[n];

		for (int i = 0; i < k; i++) {
			posChange[nextInt() - 1]++;
			negChange[nextInt() - 1]++;
		}

		int stack[] = new int[n];

		int counter = 0;
		for (int i = 0; i < n; i++) {
			counter += posChange[i];

			stack[i] = counter;

			counter -= negChange[i];
		}

		Arrays.sort(stack);

		out.println(stack[n / 2]);
		out.close();
	}
}