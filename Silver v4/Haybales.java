import java.util.*;
import java.io.*;

public class Haybales {
	static StreamTokenizer in;

	static int n, q;
	
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
		in = new StreamTokenizer(new BufferedReader(new FileReader("haybales.in")));
		PrintWriter out = new PrintWriter(new File("haybales.out"));

		n = nextInt();
		q = nextInt();

		int[] haybales = new int[n];

		for (int i = 0; i < n; i++) {
			haybales[i] = nextInt();
		}

		Arrays.sort(haybales);

		for (int i = 0; i < q; i++) {
			int low = nextInt();
			int high = nextInt();

			int l = high(haybales, low);
			int h = low(haybales, high);

			if (h < l) out.println(0);
			else out.println(h - l + 1);
		}

		out.close();
	}

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
}