import java.util.*;
import java.io.*;

public class reduce2 {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("reduce.in")));
		PrintWriter out = new PrintWriter(new File("reduce.out"));

		int n = nextInt();

		LinkedList<int[]> points = new LinkedList<>(); 
		
		for (int i = 0; i < n; i++) {
			points.add(new int[]{nextInt(), nextInt()});
		}

		int ans = Integer.MAX_VALUE;
		int[][] ihatethis = new int[3][2];

		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					LinkedList<int[]> dupPoints = (LinkedList<int[]>)points.clone();
					
					int[][] holder = determine(dupPoints);
					for (int i = 0; i < dupPoints.size(); i++) {
						if (Arrays.equals(dupPoints.get(i), holder[a])) {
							dupPoints.remove(i);
						}
					}

					holder = determine(dupPoints);
					for (int i = 0; i < dupPoints.size(); i++) {
						if (Arrays.equals(dupPoints.get(i), holder[b])) {
							dupPoints.remove(i);
						}
					}

					holder = determine(dupPoints);
					for (int i = 0; i < dupPoints.size(); i++) {
						if (Arrays.equals(dupPoints.get(i), holder[c])) {
							dupPoints.remove(i);
						}
					}

				
					int[] p = getPoints(dupPoints);
					if (area(p[0], p[1], p[2], p[3]) < ans) {
						ans = area(p[0], p[1], p[2], p[3]);

						ihatethis[0] = holder[a];
						ihatethis[1] = holder[b];
						ihatethis[2] = holder[c];
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(ihatethis[i]));
		}

		out.println(ans);
		out.close();
		
	}

	static int area(int minX, int maxX, int minY, int maxY) {
		return (maxX - minX) * (maxY - minY);
	}

	static int[] getPoints(LinkedList<int[]> points) {

		int[] arr = new int[4];

		int[][] maxX = sortX(points);
		int[][] maxY = sortY(points);

		arr[0] = maxX[0][0];
		arr[1] = maxX[1][0];
		arr[2] = maxY[0][1];
		arr[3] = maxY[1][1];

		return arr;
	}

	static int[][] determine(LinkedList<int[]> points) {

		int[][] remove = new int[4][2];

		int[][] maxX = sortX(points);
		int[][] maxY = sortY(points);

		remove[0] = maxX[0];
		remove[1] = maxX[1];
		remove[2] = maxY[0];
		remove[3] = maxY[1];

		return remove;
	}

	static int[][] sortX(LinkedList<int[]> asdf) {
		LinkedList<int[]> points = (LinkedList<int[]>)asdf.clone();
		Collections.sort(points, new Comparator<int[]>() {      
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int[][] data = new int[2][2];
		data[0] = points.getFirst();
		data[1] = points.getLast();

		return data;
	}

	static int[][] sortY(LinkedList<int[]> asdf) {
		LinkedList<int[]> points = (LinkedList<int[]>)asdf.clone();
		Collections.sort(points, new Comparator<int[]>() {      
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int[][] data = new int[2][2];
		data[0] = points.getFirst();
		data[1] = points.getLast();

		return data;
	}

	static class Point implements Comparable<Point>{
		int x,y;

		Point(int a, int b) {
			x = a;
			y = b;
		}

		public int compareTo(Point other) {
			if (x == other.x) return y - other.y;
			return x - other.x;
		}
	}

}