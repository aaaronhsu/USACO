import java.util.*;
import java.io.*;

public class MaxSubarray {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] arr = new int[n + 1];
		int min = 0;
		int ans = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			int hold = in.nextInt();
			arr[i] = hold + arr[i - 1];
			ans = Integer.max(arr[i] - min, ans);
			min = Integer.min(arr[i], min);
		}

		System.out.println(ans);
	}
}