import java.util.*;
import java.util.function.IntConsumer;
import java.io.*;

public class Maxcross2 {
	static StreamTokenizer in;
	static int n,k,b;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("maxcross.in")));
		PrintWriter out = new PrintWriter(new File("maxcross.out"));

		n = nextInt();
		k = nextInt();
		b = nextInt();

		int[] tempBoard = new int[b];
		for (int i = 0; i < b; i++) {
			tempBoard[i] = nextInt();
		}

		Arrays.sort(tempBoard);


		int[] board;
		if (tempBoard[0] == 1 && tempBoard[b - 1] == n) {
			board = tempBoard.clone();
		}
		else if (tempBoard[0] != 1 && tempBoard[b - 1] != n) {
			board = new int[b + 2];

			board[0] = 1;
			board[b + 1] = n;
			for (int i = 1; i < b + 1; i++) {
				board[i] = tempBoard[i - 1];
			}
		}
		else if (tempBoard[0] != 1) {
			board = new int[b + 1];

			board[0] = 1;
			for (int i = 1; i < b + 1; i++) {
				board[i] = tempBoard[i - 1];
			}
		}
		else {
			board = new int[b + 1];

			board[b] = n;
			for (int i = 0; i < b; i++) {
				board[i] = tempBoard[i];
			}
		}

		System.out.println(Arrays.toString(board));

		int[] prefix = new int[board.length - 1];

		for (int i = 1; i <= prefix.length; i++) {
			prefix[i - 1] = (board[i] - board[i - 1]) - 1;
		}

		System.out.println(Arrays.toString(prefix));

		for (int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i - 1] + prefix[i];
		}

		System.out.println(Arrays.toString(prefix));

		int low = 0;
		int high = prefix.length + 1;
		System.out.println(high);

		while (high - low != 1) {
			int middle = (high + low) / 2;

			if (works(middle, prefix)) high = middle;
			else low = middle;
		}

		System.out.println(low + " " + high);

		if (works(low, prefix)) out.println(low - 1);
		else out.println(high - 1);
		
		out.close();
	}

	static boolean works(int size, int[] prefix) {
		for (int i = size - 1; i < prefix.length; i++) {
			if (i == size - 1) {
				if (prefix[i] + size - 1 >= k) {
					return true;
				}
			}
			else {
				if (prefix[i] - prefix[i - size] + size - 1 >= k) {
					return true;
				}
			}
		}

		return false;
	}
}