public class simpleRecursion {
	public static void main(String[] args) {
		System.out.println(bitonic(new int[] {4, 7, 9, 5, 3, 1, 2, 3}, 0, 8));
	}

	// print the elements of an array
	static void printArray(int[] array, int index) {
		System.out.println(array[index]);
		printArray(array, index + 1);
	}

	static int bitonic(int[] array, int low, int high) {
		if (low % array.length > (high - 1) % array.length) {
			if (array[low] < array[high]) return array[low];
			return array[high];
		}

		low = low % array.length;
		high = (high - 1) % array.length;
		int middle = (high + low) / 2;


		if (array[(middle + 1) % array.length] - array[middle] > 0 && array[(middle - 1) % array.length] - array[middle] > 0) return array[middle];
		if (array[(middle + 1) % array.length] - array[middle] > 0) return bitonic(array, low, middle);
		else return bitonic(array, middle, high);
	}
}