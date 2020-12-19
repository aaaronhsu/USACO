import java.util.*;
import java.io.*;

public class d1p1 {
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("input.in")));
		PrintWriter out = new PrintWriter(new File("_Template.out"));

		int n = 200;

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) arr[i] = nextInt();

		for (int i = 0; i < n; i++) {
			for (int a = i + 1; a < n; a++) { 
				for (int b = a + 1; b < n; b++) {
					if (arr[i] + arr[a] + arr[b] == 2020) {
						System.out.println(arr[i] * arr[a] * arr[b]);
						break;
					}
				}
			}
		}
	}
}