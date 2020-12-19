import java.util.*;
import java.io.*;

public class Milkvisits2 {
	static StreamTokenizer in;
	static int n, k;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("milkvisits.in")));
		PrintWriter out = new PrintWriter(new File("milkvisits.out"));

		n = nextInt();
		k = nextInt();

		String m = next();

		Farm[] farms = new Farm[n];

		for (int i = 0; i < n; i++) {
			farms[i] = new Farm(m.charAt(i));
		}

		for (int i = 0; i < n - 1; i++) {
			int f1 = nextInt() - 1;
			int f2 = nextInt() - 1;

			farms[f1].connected.add(f2);
			farms[f2].connected.add(f1);
		}

		boolean[] seen = new boolean[n];

		int group = 1;
		int[] groups = new int[n];

		for (int i = 0; i < n; i++) {
			if(!seen[i]) {
				dfs(farms, i, seen, groups, farms[i].type, group);
				group++;
			}
		}

		for (int i = 0; i < k; i++) {
			int start = nextInt() - 1;
			int end = nextInt() - 1;
			int type = (int) next().charAt(0) == 71 ? -1 : 1;

			if (farms[start].type == type || groups[start] != groups[end]) {
				out.print("1");
			}
			else {
				out.print("0");
			}
		}

		out.println();
		out.close();

		
	}

	static void dfs(Farm farms[], int index, boolean[] seen, int[] groups, int target, int label) {
		if (seen[index] || farms[index].type != target) return;

		groups[index] = label;
		seen[index] = true;

		for (int i : farms[index].connected) {
			dfs(farms, i, seen, groups, target, label);
		}
	}

	static class Farm {
		LinkedList<Integer> connected = new LinkedList<>();
		int type = 0; // -1 is G, 1 is H

		Farm(char type) {
			this.type = (int) type == 71 ? -1 : 1;
		}
		
	}
}