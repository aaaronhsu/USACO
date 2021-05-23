import java.util.Arrays;

public class Steps {
  public static void main(String[] args) {

  }

  static int steps(int n, int[] steps) {
    int[] dp = new int[n + 1];

    for (int step : steps) {
      if (step <= n) dp[step]++;
    }

    for (int i = 0; i < n; i++) {
      for (int step : steps) {
        if (i + step <= n) dp[i + step] += dp[i];
      }
    }

    return dp[n];
  }
}
