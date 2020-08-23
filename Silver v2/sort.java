import java.util.*;
import java.io.*;

public class sort {
	static StreamTokenizer in;

	static int n;
	static boolean[] seen;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("sort.in")));
		PrintWriter out = new PrintWriter(new File("sort.out"));

		n = nextInt();

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = nextInt();
			arr[i][1] = i;
		}

		int[][] sortedArr = arr.clone();
		Arrays.sort(sortedArr, (a,b) -> {
			return a[0] - b[0];
		});

		int[] positions = new int[n];

		for (int i = 0; i < n; i++) {
			positions[i] = sortedArr[i][1];
		}

		int ans = -1;

		for (int i = 0; i < n; i++) {
			if (positions[i] - i + 1 > ans) ans = positions[i] - i + 1; 
		}

		out.println(ans);
		out.close();
		
	}
}