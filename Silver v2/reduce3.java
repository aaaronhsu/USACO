import java.util.*;
import java.io.*;

public class reduce3 {
	static StreamTokenizer in;

	static int n;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("reduce.in")));
		PrintWriter out = new PrintWriter(new File("reduce.out"));

		n = nextInt();

		Point[] cows = new Point[n];

		for (int i = 0; i < n; i++) {
			cows[i] = new Point(nextInt(), nextInt());
		}

		int ans = Integer.MAX_VALUE;

		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					Point[] dupCows = cows.clone();

					if (a % 4 == 0) {
						dupCows = sortX(dupCows);

						for (int i = 0; i < n; i++) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					else if (a % 4 == 1) {
						dupCows = sortY(dupCows);

						for (int i = 0; i < n; i++) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					else if (a % 4 == 2) {
						dupCows = sortX(dupCows);

						for (int i = n - 1; i >= 0; i--) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}
					else {
						dupCows = sortY(dupCows);

						for (int i = n - 1; i >= 0; i--) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					if (b % 4 == 0) {
						dupCows = sortX(dupCows);

						for (int i = 0; i < n; i++) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					else if (b % 4 == 1) {
						dupCows = sortY(dupCows);

						for (int i = 0; i < n; i++) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					else if (b % 4 == 2) {
						dupCows = sortX(dupCows);

						for (int i = n - 1; i >= 0; i--) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}
					else {
						dupCows = sortY(dupCows);

						for (int i = n - 1; i >= 0; i--) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					if (c % 4 == 0) {
						dupCows = sortX(dupCows);

						for (int i = 0; i < n; i++) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					else if (c % 4 == 1) {
						dupCows = sortY(dupCows);

						for (int i = 0; i < n; i++) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					else if (c % 4 == 2) {
						dupCows = sortX(dupCows);

						for (int i = n - 1; i >= 0; i--) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}
					else {
						dupCows = sortY(dupCows);

						for (int i = n - 1; i >= 0; i--) {
							if (!dupCows[i].ignore) {
								dupCows[i].ignore = true;
								break;
							}
						}
					}

					int pot = calculateArea(dupCows);
					if (pot < ans) {
						ans = pot;
					}
				}
			}
		}

		out.println(ans);
		out.close();
	}

	static int calculateArea(Point[] cows) {
		Point[] x = sortX(cows);
		Point[] y = sortY(cows);

		int xLow = 0;
		int xHigh = 0;
		int yLow = 0;
		int yHigh = 0;

		for (int i = 0; i < n; i++) {
			if (!x[i].ignore) {
				xLow = x[i].x;
				break;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (!x[i].ignore) {
				xHigh = x[i].x;
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			if (!y[i].ignore) {
				yLow = y[i].y;
				break;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (!y[i].ignore) {
				yHigh = y[i].y;
				break;
			}
		}

		return (xHigh - xLow) * (yHigh - yLow);
	}

	static Point[] sortX(Point[] cows) {
		Arrays.sort(cows, (a,b)-> {
			if(a.x == b.x) return a.y-b.y;
			return a.x-b.x;
		});

		return cows;
	}

	static Point[] sortY(Point[] cows) {
		Arrays.sort(cows, (a,b)-> {
			if(a.y == b.y) return a.x-b.x;
			return a.y-b.y;
		});

		return cows;
	}



	static class Point implements Comparable<Point>{
		int x,y;

		boolean ignore = false;

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