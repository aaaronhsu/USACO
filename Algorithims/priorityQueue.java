import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class priorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(); // duplicates allowed
		PriorityQueue<Point> q1 = new PriorityQueue<>((x,y)-> {
			if(x.x==y.x) return x.y-y.y;
			return x.x-y.x;
		});

		HashSet<Point> hashset = new HashSet<>();
		Point p1 = new Point(1,2);
		Point p2 = new Point(1,2);
		hashset.add(p1);
		hashset.add(p2);
		System.out.println(hashset.size());
		System.out.println(p1.equals(p2));
		// data stored as hashes
		// no duplicate data
		// contains is O(1)
		System.out.println(p1);
		TreeSet<Integer> set = new TreeSet<>(); // duplicates are not allowed
		TreeMap<String, Integer> students = new TreeMap<String,Integer>(); // sorted by key

		// a
		// b
		// c
	}

	static class Point implements Comparable<Point>{
		int x,y;
		Point(int a, int b){
			x = a;
			y = b;
		}
		@Override
		public int compareTo(Point other){
			if (x == other.x) return y - other.y;
			return x - other.x;
		}
		@Override
		public boolean equals(Object other){
			Point temp = (Point)other;
			return x==temp.x && y==temp.y;
			// compares x and y values of each point instead of comparing hash values
		}
		@Override
		public int hashCode(){
			return Objects.hash(x,y);
			// no duplicate values in objects
		}
		@Override
		public String toString(){
			return ""+x+" "+y;
		}
	}
}