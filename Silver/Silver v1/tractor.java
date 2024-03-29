import java.util.*;
import java.io.*;

public class tractor {
	
	static int[][] grid;
	static int n;
  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("tractor.in"));
    PrintWriter output = new PrintWriter(new File("tractor.out"));

    // Start code here
    n = input.nextInt();
    grid = new int[n][n];
    
    for(int i = 0; i < n; i++) {
    	for(int a = 0; a < n; a++) {
    		grid[i][a] = input.nextInt();
    	}
    }
    
    output.println(binSearch());
    output.close();
  }
  // [T T T T F F F]
  
  static int floodfill(int x, int y, int cost, boolean[][] visited, int from) {
	  if(x >= n || y >= n || y < 0 || x < 0 || visited[x][y] || Math.abs(from - grid[x][y]) > cost) {
		  return 0;
	  }
	  visited[x][y] = true;
	  int holder = 1;
	  holder += floodfill(x + 1, y, cost, visited, grid[x][y]);
	  holder += floodfill(x - 1, y, cost, visited, grid[x][y]);
	  holder += floodfill(x, y + 1, cost, visited, grid[x][y]);
	  holder += floodfill(x, y - 1, cost, visited, grid[x][y]);
	  
	  return holder;
  }
  static boolean works(int cost) {
	  boolean[][] visited = new boolean[n][n];
	  for(int i = 0; i < n; i++) {
		  for(int a = 0; a < n; a++) {
			  if(!visited[i][a]) {
				  if(floodfill(i, a, cost, visited, grid[i][a]) > ((n * n) / 2)) {
					  return true;
				  }
			  }
		  }
	  }
	  
	  return false;
  }

  static int binSearch() {
	  int low = 0;
	  int high = 1000000;
	  
	  while (high - low != 1) {
		  int mid = (high + low) / 2;
		  
		  if(works(mid)) high = mid;
		  else low = mid;
	  }
	  
	  return works(low)? low: high;
  }
}
