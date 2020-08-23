import java.util.*;
import java.io.*;

public class reduce {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("reduce.in")));
		PrintWriter out = new PrintWriter(new File("reduce.out"));

		int n = nextInt();

		int[][] points = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			points[i][0] = nextInt();
			points[i][1] = nextInt();
		}
		
		points = determine(points);
		for (int i = 0; i < points.length; i++) {
			System.out.println(Arrays.toString(points[i]));
		}

		int ans = Integer.MAX_VALUE;

		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					for (int d = 0; d < 4; d++) {

						int[][] dupPoints = points.clone();
						int[][] holder = determine(dupPoints);
						

						holder = determine(dupPoints);


						holder = determine(dupPoints);


						holder = determine(dupPoints);

						int[] p = getPoints(dupPoints);
						if (area(p[0], p[1], p[2], p[3]) < ans) {
							ans = area(p[0], p[1], p[2], p[3]);
						}
					}
				}
			}
		}

		out.println(ans);
		out.close();
		
	}

	static int area(int minX, int maxX, int minY, int maxY) {
		return (maxX - minX) * (maxY - minY);
	}

	static int[] getPoints(int[][] points) {

		int[] arr = new int[4];

		int[][] maxX = sortX(points);
		int[][] maxY = sortY(points);

		arr[0] = maxX[0][0];
		arr[1] = maxX[points.length - 1][0];
		arr[2] = maxY[0][1];
		arr[3] = maxY[points.length - 1][1];

		return arr;
	}

	static int[][] determine(int[][] points) {

		int[][] remove = new int[4][2];

		int[][] maxX = sortX(points);
		int[][] maxY = sortY(points);

		remove[0] = maxX[0];
		remove[1] = maxX[points.length - 1];
		remove[2] = maxY[0];
		remove[3] = maxY[points.length - 1];

		return remove;
	}

	static int[][] sortX(int[][] asdf) {
		int[][] points = asdf.clone();
		Arrays.sort(points, new Comparator<int[]>() {      
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		return points;
	}

	static int[][] sortY(int[][] asdf) {
		int[][] points = asdf.clone();
		Arrays.sort(points, new Comparator<int[]>() {      
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		return points;
	}

}