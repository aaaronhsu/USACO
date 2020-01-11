
public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 3, 5, 7};
		int target = 4;

		System.out.println(low(arr, target));
		System.out.println(high(arr, target));
	}

	static int low(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int middle = (high + low) / 2;

		while(low <= high) {
			middle = (high + low) / 2;

			if(arr[middle] == target) return middle;
			else if(arr[middle] < target) low = middle + 1;
			else high = middle - 1;
		}

		return high;
	}

	static int high(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int middle = (high + low) / 2;

		while(low <= high) {
			middle = (high + low) / 2;

			if(arr[middle] == target) return middle;
			else if(arr[middle] < target) low = middle + 1;
			else high = middle - 1;
		}

		return low;
	}

}
