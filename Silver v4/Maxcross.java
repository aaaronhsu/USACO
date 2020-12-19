import java.util.*;
import java.io.*;

public class Maxcross {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception {
		in.nextToken();
		return (String) in.sval;
	}
	
	static long nextLong() throws Exception {
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("maxcross.in")));
		PrintWriter out = new PrintWriter(new File("maxcross.out"));

		int n = nextInt();
		int k = nextInt();
		int b = nextInt();

		int[] broken = new int[b];
		
		for (int i = 0; i < b; i++) {
			broken[i] = nextInt() - 1;
		}

		Arrays.sort(broken);

		int ans = b;

		for (int i = 0; i < n - k + 1; i++) {
			int end = i + k - 1;

			int l = high(broken, i);
			int h = low(broken, end);

			if (h - l + 1 < ans) ans = h - l + 1;
		}

		if (ans < 0) ans = 0;
		out.println(ans);
		out.close();


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