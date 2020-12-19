
public class binarySearch {
    public static void main(String[] args) {
		int[] arr = {2, 3, 5};
		int target = 1;

		System.out.println(high(arr, target));
	}

    // logn
	static int search(int arr[], int target) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == target) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < target) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
		// not present 
        return -1; 
    } 

    // logn
	static int high(int arr[], int target) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == target) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < target) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
		// not present 
        return l; 
    } 

    // logn
	static int low(int arr[], int target) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == target) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < target) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
		// not present 
        return r; 
    } 
}