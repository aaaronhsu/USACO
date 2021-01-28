import java.util.*;
import java.io.*;

public class Movie {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		Event[] events = new Event[n];

		for (int i = 0; i < n; i++) {
			events[i] = new Event(in.nextInt(), in.nextInt());
		}

		Arrays.sort(events);

		int ans = 0;
		int curTime = 0;
		for (int i = 0; i < n; i++) {
			if (curTime < events[i].s) {
				ans++;
				curTime = events[i].e;
			}
		}

		System.out.println(ans);
	}

	static class Event implements Comparable<Event> {
		int s, e;

		Event(int a, int b) {
			s = a;
			e = b;
		}

		public int compareTo(Event other) {
			return Integer.compare(this.e, other.e);
		}
	}
	
}