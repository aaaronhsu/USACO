import java.util.*;
import java.io.*;

public class Paint2 {
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
		in = new StreamTokenizer(System.in);
		
		setup();

		int n = nextInt();
		int q = nextInt();
		int[] strokesNeeded = new int[n];
		int[] req = new int[n];

		String fence = next();

		for (int i = 0; i < n; i++) {
			strokesNeeded[i] = ((int) fence.charAt(i)) - 65;
		}

		// init psum
		req[0] = 1;
		painted[strokesNeeded[0]].add(0);

		for (int i = 1; i < n; i++) {
			int val = strokesNeeded[i];
			req[i] = req[i - 1] + 1;

			if (painted[val].size() == 0) {
				painted[val].add(i);
				continue;
			}

			if (combinedStroke(val, (int) painted[val].get(painted[val].size() - 1), i)) {
				req[i]--;
				multiStroke[val].add(i);
			}

			painted[val].add(i);
		}

		for (int i = 0; i < q; i++) {
			int p1 = nextInt() - 1;
			int p2 = nextInt() - 1;

			int multiPainted = 0;

			for (int a = 0; a < 26; a++) {
				if (painted[a].size() == 0) continue;

				int hold = Collections.binarySearch(painted[a], p2 + 1);

				if (hold < 0) hold = (hold * -1) - 1;

				if (hold == painted[a].size()) continue;

				int val = ((ArrayList<Integer>) painted[a]).get(hold);

				if (Collections.binarySearch(multiStroke[a], val) >= 0) multiPainted++;
			}

			System.out.println(multiPainted + req[n - 1] - req[p2] + (p1 != 0 ? req[p1 - 1] : 0));
		}
	}

	static boolean combinedStroke(int ind, int p1, int p2) {
		for (int i = ind - 1; i >= 0; i--) {
			if (Collections.binarySearch(painted[i], p1) != Collections.binarySearch(painted[i], p2)) return false;
		}
		return true;
	}

	static void setup() {
		for (int i = 0; i < 26; i++) {
			multiStroke[i] = new ArrayList<Integer>();
			painted[i] = new ArrayList<Integer>();
		}
	}
}