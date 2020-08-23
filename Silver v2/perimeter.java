import java.util.*;
import java.io.*;

public class perimeter {

	static boolean[][] visited;
	static boolean[][] grid;
	static int n;

	public static void main(String[] args) throws FileNotFoundException {
    	Scanner input = new Scanner(new File("perimeter.in"));
    	PrintWriter output = new PrintWriter(new File("perimeter.out"));

		// Start code here
		n = input.nextInt();

		grid = new boolean[n + 2][n + 2];
		visited = new boolean[n + 2][n + 2];

		for (int i = 1; i < n + 1; i++) {
			char[] holder = input.next().toCharArray();
			for (int a = 1; a < n + 1; a++) {
				if (holder[a - 1] == '#') grid[i][a] = true;
			}
		}

		int highestArea = 0;
		LinkedList<int[]> potential = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				if (!visited[i][a]) {
					int area = area(i, a);
					int[] holder = {i, a};

					if (area > highestArea) {
						highestArea = area;
						potential = new LinkedList<>();
						potential.add(holder);
					}
					else if (area == highestArea) {
						potential.add(holder);
					}
				}
			}
		}

		visited = new boolean[n + 2][n + 2];

		int highestPerm = perm(potential.getFirst()[0], potential.getFirst()[1]);

		for (int[] i : potential) {
			if (!visited[i[0]][i[1]]) {
				int perm = perm(i[0], i[1]);
				if (perm < highestPerm) highestPerm = perm;
			}
		}

		output.print(highestArea + " " + highestPerm);
		output.close();
	}

	static int area(int x, int y) {
		if (x < 0 || y < 0 || x >= visited.length || y >= grid.length || visited[x][y]) return 0;

		visited[x][y] = true;

		if (!grid[x][y]) return 0;

		return 1 + area(x + 1, y) + area(x - 1, y) + area(x, y + 1) + area(x, y - 1);		
	}

	static int border(int x, int y) {
		if (x >= n + 1 || y >= n + 1 || x <= 0 || y <= 0) return 0;
		int total = 0;
		if (!grid[x + 1][y]) total++;
		if (!grid[x - 1][y]) total++;
		if (!grid[x][y + 1]) total++;
		if (!grid[x][y - 1]) total++;

		return total;
	}

	static int perm(int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || !grid[x][y]) return 0;

		visited[x][y] = true;

		return border(x, y) + perm(x + 1, y) + perm(x - 1, y) + perm(x, y + 1) + perm(x, y - 1);

	}
}
