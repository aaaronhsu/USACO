import java.util.*;
import java.io.*;

public class paintbarn {
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
		LinkedList[][] add = new LinkedList[1001][1001];
		LinkedList[][] subtract = new LinkedList[1001][1001];

		for (int i = 0; i < 1001; i++) {
			for (int a = 0; a < 1001; a++) {
				add[i][a] = new LinkedList<Integer>();
				subtract[i][a] = new LinkedList<Integer>();
			}
			
		}

		for (int i = 0; i < n; i++) {
			int x1 = nextInt();
			int y1 = nextInt();
			int x2 = nextInt();
			int y2 = nextInt();

			for (int y = y1; y < y2; y++) {
				add[x1][y].add(y1);
				subtract[x2][y].add(y2);
			}
		}

		for (int i = 0; i < 10; i++) {
			int inc = 0;
			int dec = 0;
			for (int a = 0; a < 10; a++) {
				for (int ad : (LinkedList<Integer>) add[i][a]) {
					if (ad == a) inc++;
				}

				for (int de : (LinkedList<Integer>) subtract[i][a]) {
					if (de == a) dec++;
				}

				board[i][a] += inc - dec;
				System.out.println(i + ", " + a + " inc: " + inc + " dec: " + dec);
			}
		}

		int ans = 0;
		for (int i = 0; i < 1001; i++) {
			for (int a = 0; a < 1001; a++) {
				if (board[i][a] == k) ans++;
			}
		}
		
		out.println(ans);
		out.close();
	}
}