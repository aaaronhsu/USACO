import java.util.Arrays;
import java.util.Comparator;

public class sort {
	public static void main(String[] args) {
		// nlogn runtime
		
		int N = 10;
		Point[] array = new Point[N];
		for (int i = 0; i < N; i++) array[i] = new Point(i, i + 1);

		Arrays.sort(array, new Comparator<Point>(){
			@Override // compares points by their x value and y value
			public int compare(Point a, Point b){
				if (a.x==b.x) return a.y-b.y;
				return a.x-b.x;
				// sorts least to greatest
				// if positive -> b goes first, then a
				// if negative -> a goes first, then b
				// if tie, then compare y values
			}
		});


		// POINT CLASS
		Arrays.sort(array, (a,b)-> a.x-b.x);

		// tiebreaker POINT CLASS
		Arrays.sort(array, (a,b)-> {
			if(a.x == b.x) return a.y-b.y;
			return a.x-b.x;
		});


		Arrays.sort(array);
		String c = "A";
		String d = "B";
		System.out.println(c.compareTo(d)); // using compare function to determine which is larger, returns number (negative, 0, positive)

		
		// lambda notation
		Arrays.sort(array, (a,b) -> {
			if(a.x == b.x) return a.y - b.y;
			return a.x - b.x;
		});
	}




	static class Point implements Comparable<Point>{
		int x,y;
		Point(int a, int b){
			x = a;
			y = b;
		}
		@Override // making sure that comparing the nodes compares values, not hash values
		public int compareTo(Point other){
			if (x == other.x) return y - other.y;
			return x - other.x;
		}

		// removes hashCode
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		// removes other
		@Override
		public boolean equals(Object other) {
			Cow temp = (Cow)other;
			return temp.x == x && temp.y == y;
		}
	}
}