import java.util.*;
import java.io.*;

public class paintbarn2 {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("paintbarn.in")));
		PrintWriter out = new PrintWriter(new File("paintbarn.out"));

		int n = nextInt();
		int k = nextInt();

		int[][] board = new int[1001][1001];
		int[][] add = new int[1001][1001];
		int[][] subtract = new int[1001][1001];


		for (int i = 0; i < n; i++) {
			int a = nextInt();
			int b = nextInt();
			int c = nextInt();
			int d = nextInt();

			for (int vert = b; b < d; b++) {
				add[a][vert]++;
				subtract[c][vert]++;
			}
		}

		int ans = 0;
		for (int i = 0; i < 1001; i++) {
			int ad = 0;
			int su = 0;
			for (int a = 0; a < 1001; a++) {
				
				ad += add[i][a];
				su += subtract[i][a];
				
				if (ad - su == k) ans++;
			}
		}

		out.println(ans);
		out.close();
	}
}