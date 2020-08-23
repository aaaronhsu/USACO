
public class binarySearch {
    public static void main(String[] args) {
		int[] arr = {1, 5, 6, 7, 12, 15, 17};
		int target = 11;

		System.out.println(search(arr, target));
	}

    // logn
	static int search(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return middle;
			else if (arr[middle] > target) high = middle - 1;
			else low = middle + 1;
		}

		return -1;
	}


    // logn
	static int high(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return middle;
			else if (arr[middle] > target) high = middle;
			else low = middle;
		}

		if (arr[low] == target) return low;
		else return high;
	}

    // logn
	static int low(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return middle;
			else if (arr[middle] > target) high = middle;
			else low = middle;
		}

		if (arr[high] == target) return high;
		else return low;
	}
}