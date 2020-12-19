/*
ID: pufflew1
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

public class transform {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception{
		in.nextToken();
		return (String) in.sval;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("transform.in"));
		PrintWriter out = new PrintWriter(new File("transform.out"));

		// int[][] board = new int[3][3];

		// board[0][0] = 1;
		// board[0][1] = 0;
		// board[1][0] = 2;
		// board[1][1] = 3;

		// System.out.println(Arrays.toString(mirror(board)[0]));
		// System.out.println(Arrays.toString(mirror(board)[1]));
		// System.out.println(Arrays.toString(mirror(board)[2]));

		int n = input.nextInt();

		System.out.println(input.nextLine());

		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			String hold = input.nextLine();

			System.out.println(hold);

			for (int a = 0; a < n; a++) {
				board[i][a] = hold.charAt(a);
			}
		}

		int[][] target = new int[n][n];

		for (int i = 0; i < n; i++) {
			String hold = input.nextLine();

			for (int a = 0; a < n; a++) {
				target[i][a] = hold.charAt(a);
			}
		}

		// 90
		if (equal(turn(board), target)) out.println(1);
		else if (equal(turn(turn(board)), target)) out.println(2);
		else if (equal(turn(turn(turn(board))), target)) out.println(3);
		else if (equal(mirror(board), target)) out.println(4);
		else if (equal(turn(mirror(board)), target)) out.println(5);
		else if (equal(turn(turn(mirror(board))), target)) out.println(5);
		else if (equal(turn(turn(turn(mirror(board)))), target)) out.println(5);
		else if (equal(board, target)) out.println(6);
		else out.println(7);

		out.close();
	}
	static int[][] turn(int[][] board) {
		int[][] hold = new int[board.length][board.length];

		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board.length; a++) {
				hold[a][board.length - 1 - i] = board[i][a]; 
			}
		}

		return hold;
	}

	static int[][] mirror(int[][] board) {
		int[][] hold = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board.length; a++) {
				hold[i][a] = board[i][board.length - 1 - a];
			}
		}

		return hold;
	}

	static boolean equal(int[][] board, int[][] other) {
		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board.length; a++) {
				if (board[i][a] != other[i][a]) return false;
			}
		}

		return true;
	}
}