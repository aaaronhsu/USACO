import java.util.*;
import java.io.*;

public class homework {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("homework.in")));
		PrintWriter out = new PrintWriter(new File("homework.out"));

		int n = nextInt();
		int[] hw = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			hw[i] = nextInt();
		}

		int[] sum = new int[n];
		sum[0] = hw[0];
		
		int currentLowest = Integer.MAX_VALUE;
		int ans = -1;
		HashSet<Integer> answers = new HashSet<>();

		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + hw[i];
			if (hw[i] < currentLowest) currentLowest = hw[i];

			if ((sum[i] - currentLowest) / i > ans) {
				ans = (sum[i] - currentLowest) / i;
				answers = new HashSet<Integer>();
				answers.add(n - i - 1);
			}
			else if ((sum[i] - currentLowest) / i == ans) {
				answers.add(n - i - 1);
			}
		}
		
		for (int i : answers) {
			out.println(i);
		}
		out.close();
	}
}