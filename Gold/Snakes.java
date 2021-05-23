import java.util.*;
import java.io.*;

public class Snakes {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("input.in")));

		int n = nextInt();
		int l = nextInt();
		int s = nextInt();

		HashMap<Integer, Integer> ladders = new HashMap<>();
		HashMap<Integer, Integer> snakes = new HashMap<>();
		
		for (int i = 0; i < l; i++) {
			int a = nextInt();
			int b = nextInt();
			ladders.put(Integer.min(a, b), Integer.max(a, b));
		}
		for (int i = 0; i < s; i++) {
			int a = nextInt();
			int b = nextInt();
			snakes.put(Integer.min(a, b), Integer.max(a, b));
		}

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			
			for (int j = i + 1; j <= i + 6; j++) {
				if (j >= n) break;
				
				if (ladders.containsKey(i)) {
					if (dp[ladders.get(j)] == 0) dp[ladders.get(j)] = dp[i] + 1;
					else dp[ladders.get(j)] = Integer.min(dp[ladders.get(j)], dp[i] + 1);
				}
				if (snakes.containsKey(j)) {
					if (dp[snakes.get(j)] == 0) dp[snakes.get(j)] = dp[i] + 1;
					else dp[snakes.get(j)] = Integer.min(dp[snakes.get(j)], dp[i] + 1);
				}
				else {
					if (dp[j] == 0) dp[j] = dp[i] + 1;
					else dp[j] = Integer.min(dp[j], dp[i] + 1);
				}
			}
		}

		
	}
}