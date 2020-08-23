import java.util.*;
import java.io.*;
import java.time.Year;

public class moop1 {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("moop.in")));
		PrintWriter out = new PrintWriter(new File("moop.out"));


		int cows = nextInt();
		Particle[] particles = new Particle[cows];

		for (int i = 0; i < cows; i++) {
			particles[i] = new Particle(nextInt(), nextInt());
		}


		Arrays.sort(particles, new Comparator<Particle>() {
			@Override // compares points by their x value and y value
			public int compare(Particle a, Particle b){
				if (a.x==b.x) return a.y-b.y;
				return a.x-b.x;
				// sorts least to greatest
				// if positive -> b goes first, then a
				// if negative -> a goes first, then b
				// if tie, then compare y values
			}
		});

		int currentMin = Integer.MAX_VALUE;
		int ans = 1;

		for (int i = 0; i < cows; i++) {
			Particle[] holder = particles.clone();

			if (particles[i].y < currentMin) {
				currentMin = particles[i].y;
			}


		}
		
	}

	static class Particle implements Comparable<Particle> {
		int x;
		int y;

		Particle(int a, int b) {
			x = a;
			y = b;
		}

		@Override // making sure that comparing the nodes compares values, not hash values
		public int compareTo(Particle other){
			if (x == other.x) return y - other.y;
			return x - other.x;
		}
	}
}