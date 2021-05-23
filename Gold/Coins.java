import java.util.*;
import java.io.*;

public class Coins {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(System.in);

		int n = nextInt();
		int k = nextInt() + 1;
		int[] coins = new int[n];
		int[] dp = new int[k];

		for (int i = 0; i < n; i++) {
			coins[i] = nextInt();
			if (coins[i] > k + 1) continue;
			dp[coins[i]] = 1;
		}

		for (int i = 0; i < k; i++) {
			for (int a : coins) {
				if (a > k + 1) continue;

				if (i - a >= 0) {
					if (dp[i] == 0 && dp[i - a] != 0) {
						dp[i] = dp[i - a] + 1;
					}
					else {
						dp[i] = Integer.min(dp[i], dp[i - a] + 1);
					}
				}
			}
		}

		System.out.println(dp[k - 1] == 0 ? -1 : dp[k - 1]);
	}
}