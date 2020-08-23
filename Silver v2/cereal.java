import java.util.*;
import java.io.*;

public class cereal {
	static StreamTokenizer in;
	static int n;
	static int m;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("cereal.in")));
		PrintWriter out = new PrintWriter(new File("cereal.out"));

		n = nextInt();
		m = nextInt();

		int[][] pref = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				pref[i][j] = nextInt() - 1;
			}
		} 

		for (int i = 0; i < n; i++) {
			out.println(feed(pref, i));
		} 

		out.close();

	}

	static int feed(int[][] pref, int start) {
		int feed = 0;
		boolean[] cer = new boolean[m];
		for(int i = start; i < n; i++) {
			if (!cer[pref[i][0]]) {
				cer[pref[i][0]] = true;
				feed++;
			}
			else if (!cer[pref[i][1]]) {
				cer[pref[i][1]] = true;
				feed++;
			}
		}

		return feed;
	}
}