import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class cowdance {
	static StreamTokenizer in;

	static int n;
	static int time;
	static int[] cows;

	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("cowdance.in")));
		PrintWriter out = new PrintWriter(new File("cowdance.out"));

		n = nextInt();
		time = nextInt();
		cows = new int[n];

		for (int i = 0; i < n; i++) {
			cows[i] = nextInt();
		}

		out.println(high());
		out.close();
	}

	static int high() {
		int low = 1;
		int high = 10000;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle)) high = middle;
			else low = middle;
		}

		if (works(low)) return low;
		else return high;
	}

	static boolean works(int size) {
		PriorityQueue<Integer> stage = new PriorityQueue<>();
		int nextCow = size;
		
		if (size > cows.length) {
			int[] holder = cows.clone();
			Arrays.sort(holder);
			if (holder[holder.length - 1] <= time) return true;
			return false;
		}
		for (int i = 0; i < size; i++) {
			stage.add(cows[i]);
		}

		while (nextCow < cows.length) {
			int remove = stage.remove();
			stage.add(cows[nextCow] + remove);
			nextCow++;
		}

		while (stage.size() > 1) {
			stage.remove();
		}

		if (stage.remove() <= time) return true;
		return false;
	}
}