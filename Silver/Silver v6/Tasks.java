import java.util.*;
import java.io.*;

public class Tasks {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		Task[] tasks = new Task[n];
		for (int i = 0; i < n; i++) tasks[i] = new Task(in.nextInt(), in.nextInt());

		int ans = 0;

		Arrays.sort(tasks);
		int curTime = 0;
		for (int i = 0; i < n; i++) {
			curTime += tasks[i].time;
			
			ans += tasks[i].deadline - curTime;
		}

		System.out.println(ans);
	}	

	static class Task implements Comparable<Task> {
		int time, deadline;

		Task (int a, int b) {
			time = a;
			deadline = b;
		}

		public int compareTo(Task other) {
			return Integer.compare(this.time, other.time);
		}
	}
}
