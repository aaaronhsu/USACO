import java.util.*;
import java.io.*;

public class Cowdance {
	static StreamTokenizer in;

	static int n, maxT;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}
	static long nextLong() throws Exception{
		in.nextToken();
		return (long) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("cowdance.in")));
		PrintWriter out = new PrintWriter(new File("cowdance.out"));

		n = nextInt();
		maxT = nextInt();

		LinkedList<Cow> cows = new LinkedList<>();
		for (int i = 0; i < n; i++) cows.add(new Cow(nextInt()));

		int low = 1;
		int high = n;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, (LinkedList) cows.clone())) high = middle;
			else low = middle;
		}

		works(1, (LinkedList) cows.clone());
		if (works(low, cows)) out.println(low);
		else out.println(high);

		out.close();



		boolean a = true;
		int b = 0;
		if (a) {
			b++;
		}

		boolean c = true;
		int d = 0;
		while (c) {
			d++;
			c = false;
		}
	}

	static boolean works(int size, LinkedList<Cow> cows) {
		int time = 0;

		TreeSet<Cow> stage = new TreeSet<>();

		for (int i = 0; i < size; i++) {
			stage.add(cows.pollFirst());
		}

		while (stage.first().enter >= time) {
			time += stage.first().dance;
			if (time > maxT) return false;

			stage.pollFirst();

			if (cows.size() != 0) {
				cows.getFirst().enter = time;
				stage.add(cows.pollFirst());
			}
			else if (stage.size() == 0) {
				return true;
			}
		}

		return true;
	}
	
	static class Cow implements Comparable<Cow> {
		int enter, dance;

		Cow (int n) {
			dance = n;
		}

		@Override // making sure that comparing the nodes compares values, not hash values
		public int compareTo(Cow other){
			return (dance + enter) - (other.dance + other.enter);
		}
	}
}