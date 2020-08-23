import java.util.*;
import java.io.*;

public class wormsort {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
	} 
	
	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("wormsort.in")));
		PrintWriter out = new PrintWriter(new File("wormsort.out"));

		int n = nextInt();
		int m = nextInt();

		int cows[] = new int[n];
		LinkedList changes = new LinkedList<Integer[]>();
		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();

			if (cows[i] != i + 1) {
				changes.add(new int[] {cows[i], i + 1});
			}
		}

		int[][] wormholes = new int[m][3];

		for (int i = 0; i < m; i++) {
			wormholes[i][0] = nextInt();
			wormholes[i][1] = nextInt();
			wormholes[i][2] = nextInt();
		}

		sortbyColumn(wormholes, 2);

		
	}

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


	static LinkedList[] buildGraph(int[][] wormholes, int count) {
		LinkedList[] graph = new LinkedList[count];
		for (int i = 0; i < count - 1; i++) {
			graph[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < count - 1; i++) {
			graph[i].add(wormholes[i][1]);
			graph[wormholes[i][1]].add(graph[i]);
		}

		return graph;
	}
}