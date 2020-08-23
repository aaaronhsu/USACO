import java.util.*;
import java.io.*;

public class Paintbarn {
	static StreamTokenizer in;

	static int n, k;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("paintbarn.in")));
		PrintWriter out = new PrintWriter(new File("paintbarn.out"));

		n = nextInt();
		k = nextInt();

		int[][] change = new int[1001][1001];
		for (int i = 0; i < n; i++) {
			int x1 = nextInt();
			int y1 = nextInt();
			int x2 = nextInt();
			int y2 = nextInt();

			for (int a = x1; a < x2; a++) {
				change[a][y1]++;
				change[a][y2]--;
			}
		}

		int ans = 0;

		for (int i = 0; i < 1001; i++) {
			int add = 0;

			System.out.println(Arrays.toString(change[i]));

			for (int a = 0; a < 1001; a++) {
				add += change[i][a];

				if (add == k) ans++;
			}
		}

		out.println(ans);
		out.close();


	}
}