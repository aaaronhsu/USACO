import java.util.*;
import java.io.*;

public class Paint {
	static StreamTokenizer in;
	static ArrayList[] multiStroke = new ArrayList[26];
	static ArrayList[] painted = new ArrayList[26];
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception {
		in.nextToken();
		return (String) in.sval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("paint.in")));
		int n = nextInt();
		int k = nextInt();
		int[] strokesNeeded = new int[n];


		String fence = next();
		int[] req = new int[n];
		for (int i = 0; i < n; i++) req[i] = fence.charAt(i) - 65;

		for (int i = 0; i < 26; i++) {
			multiStroke[i] = new ArrayList<Integer>();
			painted[i] = new ArrayList<Integer>();
		}

		req[0] = 1;
		painted[strokesNeeded[0]].add(0);

		// creation of prefix
		for (int i = 1; i < n; i++) {
			int currentFence = req[i];

			req[i] = req[i - 1] + 1;

			if (combinedStroke(req[i], (int) painted[currentFence].get(painted[currentFence].size() - 1), i)) {
				req[i]--;
				painted[currentFence].add(i);
			}

			painted[currentFence].add(i);
		}

		for (int i = 0; i < k; i++) {
			int p1 = nextInt();
			int p2 = nextInt();

			int ret = 0;
			if (p1 == 0) ret += req[p1 - 1];

			int multiPaint = 0;

			for (int j = 0; j < 26; j++) {
				if (multiStroke[j].size() == 0) continue;
				
				int pot = Collections.binarySearch(painted[j], p2 + 1);

				pot = pot < 0 ? (pot * -1) -1 : pot;

				if (pot == painted[j].size()) continue;

				if (Collections.binarySearch(multiStroke[j], multiStroke[j].get(pot)) >= 0) multiPaint++;
			}

			System.out.println(multiPaint + req[n - 1] - req[p2]);
		}


	}

	static boolean combinedStroke(int ind, int p1, int p2) {
		for (int i = ind - 1; i > -1; i--) {
			if (Collections.binarySearch(painted[i], p1) != Collections.binarySearch(painted[i], p2)) return false;
		}

		return true;
	}
}