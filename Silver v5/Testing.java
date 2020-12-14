import java.util.*;
import java.io.*;

public class Testing {
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
		int[] arr = {1, 2, 3, 6, 8, 123, 346346};

		System.out.println(Arrays.binarySearch(arr, 9));
	}
}