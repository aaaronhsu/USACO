import java.util.*;
import java.io.*;

public class Highcard {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("highcard.in")));
		PrintWriter out = new PrintWriter(new File("highcard.out"));

		int n = nextInt();

		int[] elsie = new int[n];

		for (int i = 0; i < n; i++) {
			elsie[i] = nextInt();
		}
		Arrays.sort(elsie);

		int[] bessie = new int[n];

		int start = 1;
		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int a = start; a < elsie[i]; a++) {
				bessie[index] = a;
				index++;
			}

			start = elsie[i] + 1;
		}

		for (int i = start; i <= n * 2; i++) {
			bessie[index] = i;
			index++;
		}

		int ans = 0;
		int low = 0;

		for (int i = 0; i < n; i++) {
			int play = leastgreater(bessie, low, n - 1, elsie[i]);

			if (play == -1 || bessie[play] < elsie[i]) break;

			ans++;
			low = play + 1;
		}

		out.println(ans);
		out.close();
	}

	static int leastgreater(int[] a, int low, int high, int key) 
	{ 
	    int ans = -1; 
	
	    while (low <= high) { 
	        int mid = low + (high - low + 1) / 2; 
	        int midVal = a[mid]; 
		
	        if (midVal < key) { 
			
	            // if mid is less than key, all elements 
	            // in range [low, mid - 1] are <= key 
	            // then we search in right side of mid 
	            // so we now search in [mid + 1, high] 
	            low = mid + 1; 
	        } 
	        else if (midVal > key) { 
			
	            // if mid is greater than key, all elements 
	            // in range [mid + 1, high] are >= key 
	            // we note down the last found index, then  
	            // we search in left side of mid 
	            // so we now search in [low, mid - 1] 
	            ans = mid; 
	            high = mid - 1; 
	        } 
	        else if (midVal == key) { 
			
	            // if mid is equal to key, all elements in 
	            // range [low, mid] are <= key 
	            // so we now search in [mid + 1, high] 
	            low = mid + 1; 
	        } 
	    } 
	
	    return ans; 
	}  
}