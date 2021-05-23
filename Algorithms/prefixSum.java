public class prefixSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		
	}

	// N to create prefix array, 1 to retrieve value
	static int sum(int[] arr, int index) {
		int[] sum = new int[arr.length + 1];

		for (int i = 0; i < sum.length - 1; i++) {
			sum[i + 1] = sum[i] + arr[i];
		}

		return sum[index + 1];
	}

	static int range(int[] arr, int start, int end) {
		return sum(arr, end) - sum(arr, start - 1);
	}
}