import java.util.*;
import java.io.*;

public class CoinCombination {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("input.in")));

		int n = nextInt();
		int k = nextInt();

		int[] coins = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coins[i] = nextInt();
			
			if (coins[i] < k + 1) dp[coins[i]]++;
		}

		for (int i = 0; i < k + 1; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] += dp[i - coin];
				}
			}
		}

		System.out.println(Arrays.toString(dp));
	}
}