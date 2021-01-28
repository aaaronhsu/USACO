import java.util.*;
import java.io.*;
import java.lang.*;

public class pails {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("pails.in")));
		PrintWriter out = new PrintWriter(new File("pails.out"));

		int x = nextInt();
		int y = nextInt();
		int k = nextInt();
		int m = nextInt();

		if (x > y) {
			int holder = y;
			y = x;
			x = holder;
		}

		// ArrayList<Integer> low = new ArrayList<>();
		// ArrayList<Integer> high = new ArrayList<>();

		int[] low = new int[((y / x) + 2) * 2];
		int[] high = new int[((y / x) + 2) * 2];

		System.out.println(low.length);

		// low.add(0);

		// for (int i = x; i <= x + (y / x) * x; i += x) {
		// 	low.add(i);
		// 	low.add(i);
		// }
		
		// low.add(x + y);
		// high.add(x + y);

		// for (int i = y; i >= y % x; i -= x) {
		// 	high.add(i);
		// 	high.add(i);
		// }

		// high.add(0);

		int index = 1;
		for (int i = x; i <= x + (y / x) * x; i += x) {
			low[index] = i;
			low[index + 1] = i;
			index += 2;
		}
		low[(((y / x) + 2) * 2) - 1] = x + y;
		high[0] = x + y;

		index = 1;
		for (int i = y; i >= y % x; i -=x) {
			high[index] = i;
			high[index + 1] = i;
			index += 2;
		}


		System.out.println(Arrays.toString(low));
		System.out.println(Arrays.toString(high));

		for (int i = 0; i < low.length; i++) {
			System.out.print(Math.abs(m - low[i]) + " ");
		}

		System.out.println("");

		for (int i = 0; i < high.length; i++) {
			System.out.print(Math.abs(m - high[i]) + " ");
		}
		int currentBest = Integer.MAX_VALUE;

		int[] potL = new int[Math.min(k, ((y / x) + 2) * 2)];
		for (int i = 0; i < Math.min(k, ((y / x) + 2) * 2); i++) {
			potL[i] = low[i];
		}
		int[] lowHold = searchL(potL, m);
		// System.out.println(Arrays.toString(lowHold));
		if (currentBest > Math.abs(lowHold[0] - m)) currentBest = Math.abs(lowHold[0] - m);
		if (currentBest > Math.abs(lowHold[1] - m)) currentBest = Math.abs(lowHold[1] - m);


		if (k > 2)	{
			int[] potH = new int[Math.min(k, ((y / x) + 2) * 2) - 2];

			for (int i = 0; i < Math.min(k, ((y / x) + 2) * 2) - 2; i++) {
				potH[i] = high[i];
			}

			int[] highHold = searchH(potH, m);
			System.out.println(Arrays.toString(highHold));


			if (currentBest > Math.abs(highHold[0] - m)) currentBest = Math.abs(highHold[0] - m);
			if (currentBest > Math.abs(highHold[1] - m)) currentBest = Math.abs(highHold[1] - m);
		}

		out.println(currentBest);
		out.close();


	}

	static int[] searchL(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return new int[] {middle, middle};
			else if (arr[middle] > target) high = middle;
			else low = middle;
		}

		return new int[] {arr[low], arr[high]};
	}

	static int[] searchH(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (arr[middle] == target) return new int[] {middle, middle};
			else if (arr[middle] > target) low = middle;
			else high = middle;
		}

		return new int[] {arr[low], arr[high]};
	}
}