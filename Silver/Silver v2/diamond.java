import java.util.*;
import java.io.*;

public class diamond {
	static StreamTokenizer in;
	
	static int n;
	static int k;

	static HashMap<Integer, Integer> prefixMap;
	static HashMap<Integer, Integer> suffixMap;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

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

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("diamond.in")));
		PrintWriter out = new PrintWriter(new File("diamond.out"));

		n = nextInt();
		k = nextInt();

		int[] diamonds = new int[n];

		prefixMap = new HashMap<>();
		suffixMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			diamonds[i] = nextInt();
		}


		Arrays.sort(diamonds);

		for (int i = 0; i < n; i++) {
			if (!prefixMap.keySet().contains(diamonds[i])) {
				prefixMap.put(diamonds[i], i);
			}

			suffixMap.put(diamonds[i], i);
		}

		int[] prefix = new int[n];
		int[] suffix = new int[n];

		prefix[0] = 1;
		suffix[0] = 1;

		for (int i = 1; i < n; i++) {
			prefix[i] = Math.max(prefix[i - 1], determine(diamonds, i, 0));
			
			suffix[i] = Math.max(suffix[i - 1], determine(diamonds, n - i - 1, 1));
		}

		int ans = 0;

		System.out.println(Arrays.toString(prefix));
		System.out.println(Arrays.toString(suffix));

		for (int i = 0; i < n; i++) {
			int total = prefix[i] + suffix[n - i - 1];

			if (total > ans) ans = total;
		}

		out.println(ans);
		out.close();


	}

	static int determine(int[] diamonds, int index, int map) {
		if (map == 0) {
			return suffixMap.get(diamonds[low(diamonds, diamonds[index] + k)]) - index + 1;
		}
		return index - prefixMap.get(diamonds[low(diamonds, diamonds[index] + k)]) + 1;
		
	}
}